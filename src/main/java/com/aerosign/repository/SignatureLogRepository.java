package com.aerosign.repository;

import com.aerosign.audit.SignatureLog;
import org.springframework.data.jpa.repository.JpaRepository;

public class SignatureLogRepository extends JpaRepository<SignatureLog, Long> {
}
