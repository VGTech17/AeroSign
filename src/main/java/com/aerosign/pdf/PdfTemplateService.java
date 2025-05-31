package com.aerosign.pdf;

import com.aerosign.entity.FlightLog;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import org.springframework.stereotype.Service;

@Service
public class PdfTemplateService {

    public void buildFlightLog (Document document, FlightLog log) throws DocumentException {
        document.add(new Paragraph("Flight log"));
        document.add(new Paragraph("AirCraft" + log.getAircraft()));
        document.add(new Paragraph("Date: " + log.getDate()));
        document.add(new Paragraph("Duration: " + log.getDuration()));
        document.add(new Paragraph("Instructor" + log.getInstructor()));
        document.add(new Paragraph("Type: " + log.getType()));
        document.add(new Paragraph("Flight log" + log.getStatus()));
    }
}
