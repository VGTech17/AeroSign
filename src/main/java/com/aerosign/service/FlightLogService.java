package com.aerosign.service;

import com.aerosign.entity.FlightLog;
import com.aerosign.repository.FlightLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightLogService {

    private final FlightLogRepository flightLogRepository;

    public FlightLogService (FlightLogRepository flightLogRepository){
        this.flightLogRepository = flightLogRepository;
    }

    public List<FlightLog> getAllLogs(){
        return flightLogRepository.findAll();
    }

    public FlightLog getById(Long id){
        return flightLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Лог с ID " + id + " не найден"));
    }

    public List<FlightLog> getLogsByStatus(String status){
        return flightLogRepository.findAll().stream()
                .filter(log -> status.equalsIgnoreCase(log.getStatus()))
                .toList();
    }
}
