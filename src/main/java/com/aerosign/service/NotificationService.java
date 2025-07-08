package com.aerosign.service;

import com.aerosign.entity.FlightLog;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final TelegramService telegramService;
    private final EmailService emailService;

    public NotificationService(TelegramService telegramService, EmailService emailService) {
        this.telegramService = telegramService;
        this.emailService = emailService;
    }

    public void notify(FlightLog log){
        String message = "Лог #" + log.getId() + " был подписан пользователем: " + log.getInstructorName();
        telegramService.send(message);
        emailService.send(message);
    }
}
