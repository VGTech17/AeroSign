package com.aerosign.controller;

import com.aerosign.entity.secondary.FlightLog;
//import com.aerosign.service.FlightDocumentService;
//import com.aerosign.service.FlightLogService;
import com.aerosign.pdf.PdfGenerator;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
/*
@RestController
@RequestMapping("/api/export")
public class ExportController {

   private final FlightLogService flightLogService;
    private final FlightDocumentService flightDocumentService;
    private final PdfGenerator pdfGenerator;

    public ExportController(FlightLogService flightLogService, FlightDocumentService flightDocumentService, PdfGenerator pdfGenerator) {
        this.flightLogService = flightLogService;
        this.flightDocumentService = flightDocumentService;
        this.pdfGenerator = pdfGenerator;
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<?> exportSignedPdf(@PathVariable Long id) {
        try {
            FlightLog log = flightLogService.getById(id);

            File file = flightDocumentService.generateTempSignedPdf(log);
            if (!file.exists()) {
                return ResponseEntity.notFound().build();
            }

            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName());

            ResponseEntity<Resource> response = ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(file.length())
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(resource);

            boolean deleted = file.delete();
            System.out.println("[TempFile] Файл " + file.getName() + " удалён: " + deleted);

            return response;

        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Ошибка при экспорте PDF: " + e.getMessage());
        }
    }
}

 */
