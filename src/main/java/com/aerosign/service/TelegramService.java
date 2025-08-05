package com.aerosign.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.io.ByteArrayResource;

@Service
public class TelegramService {

    private static final String TOKEN = "7835205775:AAEtZO_jBcdY40hf-PjggU8Hg8w0yLiCzJs";
    private static final String CHAT_ID = "410800037";
    private static final String TELEGRAM_API = "https://api.telegram.org/bot" + TOKEN + "/sendDocument";

    private final RestTemplate restTemplate = new RestTemplate();

    public void send(String message) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String json = String.format(
                "{\"chat_id\": \"%s\", \"text\": \"%s\"}",
                CHAT_ID,
                message.replace("\"", "\\\"")
        );

        HttpEntity<String> request = new HttpEntity<>(json, headers);
        restTemplate.postForEntity("https://api.telegram.org/bot" + TOKEN + "/sendMessage", request, String.class);
    }

    public void sendPdf(String caption, byte[] pdfBytes) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();

        ByteArrayResource pdfResource = new ByteArrayResource(pdfBytes) {
            @Override
            public String getFilename() {
                return "signed_flightlog.pdf";
            }
        };

        body.add("chat_id", CHAT_ID);
        body.add("caption", caption);
        body.add("document", pdfResource);

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(body, headers);
        restTemplate.postForEntity(TELEGRAM_API, request, String.class);
    }
}