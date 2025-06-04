package com.aerosign.service;

import com.aerosign.entity.FlightLog;
import com.aerosign.pdf.PdfGenerator;
import com.aerosign.pdf.PdfSigner;
import com.aerosign.pdf.PdfTemplateService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Service
public class FlightDocumentService {

    private final ValidationService validationService;
    private final PdfGenerator pdfGenerator;
    private final PdfSigner pdfSigner;
    private final PdfTemplateService pdfTemplateService;
    private final TempFileCleanerService tempFileCleanerService;

    public FlightDocumentService(ValidationService validationService, PdfGenerator pdfGenerator, PdfSigner pdfSigner, PdfTemplateService pdfTemplateService, TempFileCleanerService tempFileCleanerService) {
        this.validationService = validationService;
        this.pdfGenerator = pdfGenerator;
        this.pdfSigner = pdfSigner;
        this.pdfTemplateService = pdfTemplateService;
        this.tempFileCleanerService = tempFileCleanerService;
    }

    public String processFlightLog(FlightLog log) throws Exception {
        validationService.isFlightLogValid(log);
        String pdfPath = pdfGenerator.generate(log);
        String signedPdfPath = pdfSigner.sign(pdfPath);

        return signedPdfPath;
    }

    public File generateTempSignedPdf(FlightLog log) {
        File tempFile = null;
        try {

            File tempDir = new File("temp");
            if (!tempDir.exists()) {
                tempDir.mkdirs();
            }

            tempFile = File.createTempFile("log_" + log.getId() + "_", ".pdf", tempDir);

            String pdfPath = processFlightLog(log); // возвращает путь к PDF
            File pdfSource = new File(pdfPath);

            if (!pdfSource.exists()) {
                throw new FileNotFoundException("PDF-файл не найден: " + pdfPath);
            }

            try (FileInputStream fis = new FileInputStream(pdfSource);
                 FileOutputStream fos = new FileOutputStream(tempFile)) {

                byte[] buffer = new byte[8192];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка при генерации временного PDF: " + e.getMessage(), e);
        }

        return tempFile;
    }
}
