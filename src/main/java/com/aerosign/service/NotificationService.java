package com.aerosign.service;

import com.aerosign.dto.FlightLogDTO;
import com.aerosign.entity.secondary.FlightLog;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final TelegramService telegramService;
    private final EmailService emailService;

    public NotificationService(TelegramService telegramService, EmailService emailService) {
        this.telegramService = telegramService;
        this.emailService = emailService;
    }

    public void notify(FlightLog log, FlightLogDTO flightLogDTO, byte[] signedPdfBytes) {
        String subject = "Подпись лога #" + log.getId();
        String message = "Лог #" + log.getId() + " был подписан пользователем: " + flightLogDTO.getInstructorName();

        // Отправка текста
        telegramService.send(message);

        // Отправка PDF
        telegramService.sendPdf(subject, signedPdfBytes);

        // Отправка Email
        emailService.sendEmail(
                "valgridnev@mail.ru",
                subject,
                message
        );
    }
}