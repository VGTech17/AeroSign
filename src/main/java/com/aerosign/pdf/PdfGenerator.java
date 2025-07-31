package com.aerosign.pdf;

import com.aerosign.entity.FlightLog;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;

@Service
public class PdfGenerator {

    private final PdfTemplateService pdfTemplateService;

    public PdfGenerator(PdfTemplateService pdfTemplateService) {
        this.pdfTemplateService = pdfTemplateService;
    }

    public byte[] generateAndSavePdf(FlightLog log) {
        try {
            byte[] pdfBytes = pdfTemplateService.generateFlightLogPdf(log);

            String fileName = String.format("flightlog_%s_%s.pdf",
                    sanitize(log.getStudentName()),
                    log.getFlightDate()
            );

            Path outputDir = Paths.get("generated-pdfs");
            Files.createDirectories(outputDir);

            Path filePath = outputDir.resolve(fileName);
            try (FileOutputStream fos = new FileOutputStream(filePath.toFile())) {
                fos.write(pdfBytes);
            }

            return pdfBytes; // также возвращаем PDF в виде byte[] для REST-контроллера
        } catch (IOException e) {
            throw new RuntimeException("Не удалось сохранить PDF-документ", e);
        }
    }

    private String sanitize(String input) {
        return input.replaceAll("[^a-zA-Z0-9а-яА-Я_-]", "_");
    }
}