package com.aerosign.service;

import org.springframework.stereotype.Service;

@Service
public class TelegramService {

    public void send(String payload) {
        System.out.println("[TelegramService] Отправка сообщения в Telegram: " + payload);
        // TODO: подключить Bot API и передавать токен
    }
}
