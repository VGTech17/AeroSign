package com.aerosign.pdf;

import com.aerosign.dto.FlightLogDTO;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class PdfGenerator {

    public byte[] generatePdf(List<FlightLogDTO> logs) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            Document document = new Document();
            PdfWriter.getInstance(document, baos);

            document.open();
            document.add(new Paragraph("Журнал полётов"));
            document.add(new Paragraph(" ")); // Пустая строка

            for (FlightLogDTO log : logs) {
                document.add(new Paragraph(
                        "Дата: " + log.getDateFormatted() +
                                ", Время: " + log.getFlightTimeFormatted() +
                                ", Студент: " + log.getStudentName()
                ));
            }

            document.close();
            return baos.toByteArray();

        } catch (DocumentException | IOException e) {
            throw new RuntimeException("Ошибка при генерации PDF", e);
        }
    }
}
