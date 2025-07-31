package com.aerosign.service;

import com.aerosign.dto.FlightLogDTO;
import com.aerosign.entity.FlightLog;
import com.aerosign.mapper.FlightLogMapper;
import com.aerosign.pdf.PdfGenerator;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Service
public class FlightDocumentService {

    private final PdfGenerator pdfGenerator;
    private final FlightLogService flightLogService;

    public FlightDocumentService(PdfGenerator pdfGenerator, FlightLogService flightLogService) {
        this.pdfGenerator = pdfGenerator;
        this.flightLogService = flightLogService;
    }

    public File generateTempSignedPdf(FlightLog log) {
        try {
            List<FlightLogDTO> singleLogList = List.of(FlightLogMapper.toDTO(log));
            byte[] pdfBytes = pdfGenerator.generatePdf(singleLogList);

            File tempFile = File.createTempFile("flight_log_", ".pdf");
            Files.write(tempFile.toPath(), pdfBytes);

            return tempFile;

        } catch (IOException e) {
            throw new RuntimeException("Ошибка при генерации PDF", e);
        }
    }

    public String processFlightLog(Long id) {
        FlightLog log = flightLogService.getById(id); // получаем сущность
        List<FlightLogDTO> logs = List.of(FlightLogMapper.toDTO(log)); // оборачиваем в список
        byte[] pdfBytes = pdfGenerator.generatePdf(logs); // генерим PDF

        try {
            File tempFile = File.createTempFile("flight_log_" + id + "_", ".pdf");
            Files.write(tempFile.toPath(), pdfBytes);
            return tempFile.getAbsolutePath(); // путь к файлу
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при сохранении PDF-файла", e);
        }
    }
}
