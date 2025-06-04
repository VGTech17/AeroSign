package com.aerosign.service;

import com.aerosign.audit.SignatureLog;
import com.aerosign.entity.FlightLog;
import com.aerosign.entity.User;
import com.aerosign.repository.SignatureLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditService {

    private final SignatureLogRepository signatureLogRepository;

    public AuditService(SignatureLogRepository signatureLogRepository) {
        this.signatureLogRepository = signatureLogRepository;
    }

    public void logSignature(FlightLog flightLog, User user, String algorithm, String keySerialNumber) {
        SignatureLog log = new SignatureLog();
        log.setFlightLog(flightLog);
        log.setUser(user);
        log.setSignedAt(LocalDateTime.now());
        log.setAlgorithm(algorithm);
        log.setKeySerialNumber(keySerialNumber);

        signatureLogRepository.save(log);
    }
}
