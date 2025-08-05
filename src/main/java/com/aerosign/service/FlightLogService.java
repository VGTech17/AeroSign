package com.aerosign.service;

import com.aerosign.entity.secondary.FlightLog;
import com.aerosign.dto.FlightLogDTO;
import com.aerosign.enums.FlightLogStatus;
//import com.aerosign.mapper.FlightLogMapper;
import com.aerosign.repository.secondary.FlightLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightLogService {

    private final FlightLogRepository flightLogRepository;

    public FlightLogService(FlightLogRepository flightLogRepository) {
        this.flightLogRepository = flightLogRepository;
    }

    public List<FlightLog> getAllLogs() {
        return flightLogRepository.findAll();
    }

    /*public List<FlightLogDTO> getAllLogsDTO() {
        return flightLogRepository.findAll()
                .stream()
                .map(FlightLogMapper::toDTO)
                .toList();
    }

     */

    public FlightLog getById(Long id) {
        return flightLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Лог с ID " + id + " не найден"));
    }

    /*public List<FlightLog> getLogsByStatus(FlightLogStatus status) {
        return flightLogRepository.findAll()
                .stream()
                .filter(log -> log.getStatus() == status)
                .toList();
    }

     */
}