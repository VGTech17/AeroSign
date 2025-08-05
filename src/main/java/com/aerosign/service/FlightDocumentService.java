package com.aerosign.service;

import com.aerosign.entity.secondary.FlightLog;
import com.aerosign.entity.secondary.SignatureRecord;
import com.aerosign.pdf.PdfGenerator;
import com.aerosign.repository.secondary.SignatureRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FlightDocumentService {

    private final PdfGenerator pdfGenerator;
    private final FlightLogService flightLogService;
    private final SignatureRepository signatureRepository;

    public FlightDocumentService(
            PdfGenerator pdfGenerator,
            FlightLogService flightLogService,
            SignatureRepository signatureRepository
    ) {
        this.pdfGenerator = pdfGenerator;
        this.flightLogService = flightLogService;
        this.signatureRepository = signatureRepository;
    }

    public byte[] generateAndSignPdf(Long flightLogId) {
        // 1. Получаем лог из primary
        FlightLog log = flightLogService.getById(flightLogId);

        // 2. Генерируем PDF
        byte[] pdf = pdfGenerator.generateAndSavePdf(log);

        // 3. Создаём запись подписи в secondary
        SignatureRecord signature = new SignatureRecord();
        signature.setFlightLogId(log.getId());
        signature.setSignedAt(LocalDateTime.now());
        signature.setSigner("system"); // или логин пользователя
        signature.setComment("Подпись PDF");
        signature.setStatus("SIGNED");

        signatureRepository.save(signature);

        return pdf;
    }
}