package com.aerosign.service;

import com.aerosign.entity.primary.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FaceIdVerifier {

    private static final Logger logger = LoggerFactory.getLogger(FaceIdVerifier.class);

    public boolean verify (User user){
            logger.info("Эмуляция Face ID: пользователь '{}' прошёл проверку лица", user.getFullName());
            return true; // TODO: заменить на реальную проверку в будущем
    }
}
