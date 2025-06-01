package com.aerosign.service;

import com.aerosign.entity.FlightLog;
import com.aerosign.pdf.PdfGenerator;
import com.aerosign.pdf.PdfSigner;
import org.springframework.stereotype.Service;

@Service
public class FlightDocumentService {

    private final ValidationService validationService;
    private final PdfGenerator pdfGenerator;
    private final PdfSigner pdfSigner;

    public FlightDocumentService(ValidationService validationService, PdfGenerator pdfGenerator, PdfSigner pdfSigner) {
        this.validationService = validationService;
        this.pdfGenerator = pdfGenerator;
        this.pdfSigner = pdfSigner;
    }

    public String processFlightLog (FlightLog log) throws Exception {
        validationService.isFlightLogValid(log);
        String pdfPath = pdfGenerator.generate(log);
        String signedPdfPath = pdfSigner.sign(pdfPath);

        return signedPdfPath;
    }
}
