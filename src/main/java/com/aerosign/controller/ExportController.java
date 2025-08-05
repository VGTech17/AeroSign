package com.aerosign.controller;

import com.aerosign.dto.FlightLogDTO;
import com.aerosign.entity.primary.Attendance;
import com.aerosign.entity.primary.Drone;
import com.aerosign.entity.primary.Student;
import com.aerosign.entity.secondary.FlightLog;
import com.aerosign.mapper.FlightLogMapper;
import com.aerosign.pdf.PDFTestGenerator;
import com.aerosign.pdf.PdfGenerator;
import com.aerosign.pdf.PdfSigner;
import com.aerosign.service.FlightLogService;
import com.aerosign.service.TelegramService;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/export")
public class ExportController {

    private final FlightLogService flightLogService;
    private final PdfGenerator pdfGenerator;
    private final PDFTestGenerator pdfTestGenerator;
    private final FlightLogMapper flightLogMapper;
    private final PdfSigner pdfSigner;
    private final TelegramService telegramService;

    public ExportController(FlightLogService flightLogService,
                            PdfGenerator pdfGenerator, PDFTestGenerator pdfTestGenerator, FlightLogMapper flightLogMapper,
                            PdfSigner pdfSigner,
                            TelegramService telegramService) {
        this.flightLogService = flightLogService;
        this.pdfGenerator = pdfGenerator;
        this.pdfTestGenerator = pdfTestGenerator;
        this.flightLogMapper = flightLogMapper;
        this.pdfSigner = pdfSigner;
        this.telegramService = telegramService;
    }

    @GetMapping("/pdf/{id}")
    public ResponseEntity<?> exportPdf(@PathVariable Long id) {
        try {
            FlightLog log = flightLogService.getById(id);

            if (log == null) {
                return ResponseEntity.status(404).body("FlightLog не найден по id: " + id);
            }

            byte[] pdfBytes = pdfGenerator.generateAndSavePdf(log);
            byte[] signedPdf = pdfSigner.signPdf(pdfBytes, log);

            telegramService.sendPdf("Подписанный лог #" + id, signedPdf);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=flight_log_" + id + "_signed.pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(signedPdf);

        } catch (Exception e) {
            e.printStackTrace(); // ИЛИ log.error("Ошибка экспорта", e);
            return ResponseEntity.status(500).body("Ошибка при экспорте PDF: " + e.getMessage());
        }
    }

    @GetMapping("/test-pdf")
    public ResponseEntity<byte[]> testGeneratePdf() {
        // Заглушки — потом заменишь на реальные сущности из БД
        Attendance attendance = new Attendance();
        attendance.setTimestamp(Instant.now());
        attendance.setEndTimestamp(Instant.now().plusSeconds(1800)); // +30 мин

        Student student = new Student();
        student.setStudentName("Иванов Иван");
        student.setGroupName("Группа A");

        Drone drone = new Drone();
        drone.setDroneName("DJI Phantom 4");

        String instructorName = "Петров П.П.";

        // Маппинг и генерация
        FlightLogDTO dto = flightLogMapper.toDto(attendance, student, drone, instructorName);
        byte[] pdfBytes = pdfTestGenerator.generateAndSavePdf(dto);

        // Вернём PDF
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "test-flightlog.pdf");
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

    @PostConstruct
    public void init() {
        System.out.println("✅ ExportController загружен");
    }
}