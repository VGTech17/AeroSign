package com.aerosign.pdf;

import com.aerosign.entity.FlightLog;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;

@Service
public class PdfGenerator {

    private final PdfTemplateService templateService;

    public PdfGenerator(PdfTemplateService templateService) {
        this.templateService = templateService;
    }

    public String generate(FlightLog log) throws IOException, DocumentException {
        String filePath = "temp/flight_log_" + log.getId() + ".pdf";
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();

        templateService.buildFlightLog(document, log);

        document.close();
        return filePath;
    }
}
