package com.aerosign.validation;

import com.aerosign.entity.FlightLog;
import com.aerosign.entity.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BasicValidationService {

    public boolean isFlightLogValid(FlightLog log) {
        if (log == null) return false;

        if (log.getAircraft() == null || log.getAircraft().isBlank() || log.getAircraft().length() > 100) return false;
        if (log.getDuration() <= 0) return false;
        if (log.getInstructor() == null || !isUserValid(log.getInstructor())) return false;
        if (log.getDate() == null || log.getDate().isAfter(LocalDate.now())) return false;
        if (log.getType() == null || log.getType().isBlank() || log.getType().length() > 50) return false;
        if (log.getStatus() == null || log.getStatus().isBlank() || log.getStatus().length() > 50) return false;
        if (log.getStudent() == null || !isUserValid(log.getStudent())) return false;

        if (log.getInstructor().getId().equals(log.getStudent().getId())) return false;

        return true;
    }

    public boolean isUserValid(User user){
        if (user == null) return false;
        if (user.getId() == null || user.getName().isBlank()) return false;
        return true;
    }
}
