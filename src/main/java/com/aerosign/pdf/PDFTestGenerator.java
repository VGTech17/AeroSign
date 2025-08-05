package com.aerosign.pdf;

import com.aerosign.dto.FlightLogDTO;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;

@Component
public class PDFTestGenerator {

    public byte[] generateAndSavePdf(FlightLogDTO dto) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Document document = new Document();
            PdfWriter.getInstance(document, out);
            document.open();

            document.add(new Paragraph("ФИО студента: " + dto.getStudentName()));
            document.add(new Paragraph("Группа: " + dto.getGroupName()));
            document.add(new Paragraph("БВС: " + dto.getDroneName()));
            document.add(new Paragraph("Дата полета: " + dto.getFlightDate()));
            document.add(new Paragraph("Начало: " + dto.getTimeStart()));
            document.add(new Paragraph("Конец: " + (dto.getTimeEnd() != null ? dto.getTimeEnd() : "не указано")));
            document.add(new Paragraph("Инструктор: " + dto.getInstructorName()));

            document.close();
            return out.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при генерации PDF", e);
        }
    }
}