package com.aerosign.repository;

import com.aerosign.entity.FlightLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightLogRepository extends JpaRepository<FlightLog, Long> {
}
