package com.aerosign.entity;

import com.aerosign.entity.*;
import com.aerosign.enums.DroneType;
import com.aerosign.enums.FlightCondition;

import java.time.Duration;
import java.time.ZoneId;
import java.util.*;

public class FlightLogBuilderService {

    public FlightLog buildFrom(Attendance attendance, Date date, Student student, Teacher teacher,
                               Drone drone, Trainer instructor, TrainerType trainerType, Comment comment) {

        FlightLog log = new FlightLog();

        // 🗓️ Дата полета
        log.setFlightDate(date.getTimeStart().atZone(ZoneId.systemDefault()).toLocalDate());

        // 🚁 Тип БВС — безопасно с маппингом строки в Enum
        DroneType resolvedType = resolveDroneType(drone.getDroneName());
        log.setDroneType(resolvedType);

        // 🌦️ Условия полета (Т, О, П, И/В)
        Set<FlightCondition> conditions = resolveConditions(trainerType);
        log.setFlightConditions(conditions);

        // ✈️ Кол-во полетов
        log.setFlightCount(1); // Пока фиксированно, можно адаптировать позже

        // 🕒 Время полета
        double totalMinutes = Duration.between(date.getTimeStart(), date.getTimeStop()).toMinutes();
        double dayTime = resolveDayMinutes(totalMinutes);
        double nightTime = totalMinutes - dayTime;

        log.setDayDuration(toHourFormat(dayTime));
        log.setNightDuration(toHourFormat(nightTime));
        log.setTotalDuration(toHourFormat(totalMinutes));

        // 👨‍🎓 Студент
        log.setStudentName(student.getStudentName());

        // 👨‍🏫 Инструктор
        log.setInstructorName(teacher.getTeacherName());

        // 💬 Комментарий
        log.setComment(comment != null ? comment.getComment() : "Без комментария");

        // 🚨 Признак внешнего пилота — по массе дрона
        //log.setExternalPilot(drone.getMass() > 30.0);

        return log;
    }

    /**
     * Преобразование из строки типа БВС в DroneType (Enum)
     * Безопасно обрабатывает ошибки.
     */
    private DroneType resolveDroneType(String rawDroneCode) {
        if (rawDroneCode == null || rawDroneCode.isBlank()) {
            return DroneType.UNKNOWN;
        }

        // Удалим пробелы и приведём к верхнему регистру
        String code = rawDroneCode.trim().toUpperCase();

        // Явные соответствия
        switch (code) {
            case "С":
                return DroneType.FIXED_WING;
            case "В":
                return DroneType.ROTORCRAFT;
            case "М(4)":
                return DroneType.MULTIROTOR_4;
            case "СВ":
                return DroneType.VTOL;
            case "С*":
                return DroneType.HEAVY_EXTERNAL_PILOT;
            default:
                return DroneType.UNKNOWN; // Безопасно, не упадём на null
        }
    }

    /**
     * Преобразование условий в enum-множество.
     */
    private Set<FlightCondition> resolveConditions(TrainerType type) {
        String raw = type.getName(); // Пример: "И/П/В"
        Set<FlightCondition> result = new HashSet<>();
        for (String part : raw.split("/")) {
            try {
                result.add(FlightCondition.valueOf(part.trim()));
            } catch (IllegalArgumentException ignored) {
                // можно логгировать
            }
        }
        return result;
    }

    /**
     * Грубое разделение по времени (в будущем — уточнять по расписанию)
     */
    private double resolveDayMinutes(double total) {
        return total * 0.8;
    }

    /**
     * Формат времени: 75 мин → 1.15
     */
    private double toHourFormat(double minutes) {
        int hours = (int) (minutes / 60);
        double mins = minutes % 60;
        return hours + (mins / 100.0);
    }
}