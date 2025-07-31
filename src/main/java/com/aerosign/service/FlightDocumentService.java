package com.aerosign.service;

import com.aerosign.entity.secondary.FlightLog;
import com.aerosign.pdf.PdfGenerator;
import org.springframework.stereotype.Service;
 /*
@Service
public class FlightDocumentService {

    private final PdfGenerator pdfGenerator;
    private final FlightLogService flightLogService;

    public FlightDocumentService(PdfGenerator pdfGenerator, FlightLogService flightLogService) {
        this.pdfGenerator = pdfGenerator;
        this.flightLogService = flightLogService;
    }

    public byte[] generatePdfById(Long flightLogId) {
        FlightLog log = flightLogService.getById(flightLogId);
        return pdfGenerator.generateAndSavePdf(log);
    }

    public byte[] generatePdfFromLog(FlightLog log) {
        return pdfGenerator.generateAndSavePdf(log);
    }
}

  */