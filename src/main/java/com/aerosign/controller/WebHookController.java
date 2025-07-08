package com.aerosign.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/webhook")
public class WebHookController {

    private static final Logger logger = LoggerFactory.getLogger(WebHookController.class);

    @PostMapping("/notify")
    public ResponseEntity<String> receiveNotification(@RequestBody String payload) {
        logger.info("📩 Входящее уведомление: {}", payload);
        return ResponseEntity.ok("Уведомление получено");
    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping(){
        return ResponseEntity.ok("Webhook работает");
    }
}
