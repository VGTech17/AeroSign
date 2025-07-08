package com.aerosign.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void send(String payload) {
        System.out.println("[EmailService] Отправка письма на email: " + payload);
        // TODO: подключить SMTP через JavaMailSender
    }
}
