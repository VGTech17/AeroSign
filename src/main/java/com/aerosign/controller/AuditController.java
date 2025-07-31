package com.aerosign.controller;

import com.aerosign.audit.SignatureLog;
import com.aerosign.dto.SignatureLogDTO;
import com.aerosign.service.AuditService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/audit")
public class AuditController {

    private final AuditService auditService;

    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @GetMapping("/logs/{flightLogId}")
    public List<SignatureLogDTO> getAuditLogs(@PathVariable Long flightLogId) {
        List<SignatureLog> logs = auditService.getLogsForFlightLog(flightLogId);

        return logs.stream()
                .map(log -> new SignatureLogDTO(
                        log.getSignedAt(),
                        log.getUser().getFullName(),
                        log.getAlgorithm(),
                        log.getKeySerialNumber()
                ))
                .collect(Collectors.toList());
    }
}
