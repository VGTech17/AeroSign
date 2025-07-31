package com.aerosign.pdf;

import com.aerosign.entity.FlightLog;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class PdfTemplateService {

    public byte[] generateFlightLogPdf(FlightLog log) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, baos);
            document.open();

            Font font = new Font(Font.HELVETICA, 12, Font.NORMAL);

            // Добавляем поля
            document.add(new Paragraph("📄 Летная книжка", new Font(Font.HELVETICA, 16, Font.BOLD)));
            document.add(new Paragraph("Студент: " + log.getStudentName(), font));
            document.add(new Paragraph("Дата полета: " + log.getFlightDate(), font));
            document.add(new Paragraph("Тип БВС: " + log.getDroneType().getDescription(), font));
            document.add(new Paragraph("Условия: " + String.join(", ", log.getFlightConditions().stream().map(Enum::name).toList()), font));
            document.add(new Paragraph("Количество полетов: " + log.getFlightCount(), font));
            document.add(new Paragraph("Налёт день: " + log.getDayDuration(), font));
            document.add(new Paragraph("Налёт ночь: " + log.getNightDuration(), font));
            document.add(new Paragraph("Общий налёт: " + log.getTotalDuration(), font));
            document.add(new Paragraph("Инструктор: " + log.getInstructorName(), font));
            document.add(new Paragraph("Комментарий: " + log.getComment(), font));

            document.close();
            return baos.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException("Ошибка при создании PDF", e);
        }
    }
}
