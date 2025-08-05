package com.aerosign.pdf;

import com.aerosign.entity.secondary.FlightLog;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.time.format.DateTimeFormatter;

@Component
public class PdfGenerator {

    public byte[] generateAndSavePdf(FlightLog log) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Document document = new Document();
            PdfWriter.getInstance(document, out);
            document.open();

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            document.add(new Paragraph("ФИО студента: " + log.getStudentName()));
            document.add(new Paragraph("Дата полета: " + dateFormatter.format(log.getFlightDate())));
            document.add(new Paragraph("Вид БВС: " + log.getDroneType()));
            document.add(new Paragraph("Условия: " + log.getFlightConditions()));
            document.add(new Paragraph("Количество полетов: " + log.getFlightCount()));
            document.add(new Paragraph("Налёт (день): " + log.getDayDuration()));
            document.add(new Paragraph("Налёт (ночь): " + log.getNightDuration()));
            document.add(new Paragraph("Общий налёт: " + log.getTotalDuration()));
            document.add(new Paragraph("Инструктор: " + log.getInstructorName()));
            document.add(new Paragraph("Комментарий: " + log.getComment()));
            document.add(new Paragraph("Внешний пилот: " + (log.isExternalPilot() ? "Да" : "Нет")));

            document.close();
            return out.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при генерации PDF", e);
        }
    }
}