package com.aerosign.repository.secondary;

import com.aerosign.audit.SignatureLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SignatureLogRepository extends JpaRepository<SignatureLog, Long> {
    List<SignatureLog> findByFlightLogIdOrderBySignedAtDesc(Long flightLogId);
}
