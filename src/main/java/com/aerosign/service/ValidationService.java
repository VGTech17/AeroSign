package com.aerosign.service;

import com.aerosign.entity.FlightLog;
import com.aerosign.entity.User;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public boolean isFlightLogValid(FlightLog log) {
        if (log == null) return false;

        if (log.getAircraft() == null || log.getAircraft().isBlank()) return false;
        if (log.getDuration() <= 0) return false;
        if (log.getInstructor() == null || !isUserValid(log.getInstructor())) return false;
        if (log.getDate() == null) return false;
        if (log.getType() == null || log.getType().isBlank()) return false;
        if (log.getStatus() == null || log.getStatus().isBlank()) return false;
        if (log.getStudent() == null || !isUserValid(log.getStudent())) return false;

        return true;
    }

    public boolean isUserValid(User user){
        if (user == null) return false;
        if (user.getId() == null || user.getName().isBlank()) return false;
        return true;
    }
}
