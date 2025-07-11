package com.aerosign.security;

import com.aerosign.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FaceIdVerifier {

    private static final Logger logger = LoggerFactory.getLogger(FaceIdVerifier.class);

    public boolean verify(User user){
        logger.info("Эмуляция Face ID: пользователь '{}' прошёл проверку лица", user.getName());
        return true; // TODO: заменить на реальную проверку в будущем
    }
}
