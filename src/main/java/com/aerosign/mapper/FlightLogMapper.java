package com.aerosign.mapper;

import com.aerosign.dto.FlightLogDTO;
import com.aerosign.entity.primary.Attendance;
import com.aerosign.entity.primary.Drone;
import com.aerosign.entity.primary.Student;
import org.springframework.stereotype.Component;

import java.time.ZoneId;

@Component
public class FlightLogMapper {

    public FlightLogDTO toDto(Attendance attendance, Student student, Drone drone, String instructorName) {
        FlightLogDTO dto = new FlightLogDTO();

        dto.setStudentName(student.getStudentName());
        dto.setGroupName(student.getGroupName());
        dto.setDroneName(drone.getDroneName());
        dto.setFlightDate(attendance.getTimestamp().atZone(ZoneId.systemDefault()).toLocalDate());
        dto.setTimeStart(attendance.getTimestamp().atZone(ZoneId.systemDefault()).toLocalTime());

        if (attendance.getEndTimestamp() != null) {
            dto.setTimeEnd(attendance.getEndTimestamp().atZone(ZoneId.systemDefault()).toLocalTime());
        }

        dto.setInstructorName(instructorName); // пока хардкодим

        return dto;
    }
}