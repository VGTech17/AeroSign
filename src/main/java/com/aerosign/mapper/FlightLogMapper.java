package com.aerosign.mapper;

import com.aerosign.dto.FlightLogDTO;
import com.aerosign.entity.secondary.FlightLog;

import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class FlightLogMapper {

    /*private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static FlightLogDTO toDTO(FlightLog entity) {
        FlightLogDTO dto = new FlightLogDTO();

        // 1. Формат даты
        if (entity.getFlightDate() != null) {
            dto.setDateFormatted(entity.getFlightDate().format(DATE_FORMATTER));
        }

        // 2. Формат времени
        if (entity.getFlightTime() != null) {
            int minutes = entity.getFlightTime();
            int hours = minutes / 60;
            int mins = minutes % 60;
            dto.setFlightTimeFormatted(hours + " ч " + mins + " мин");
        }

        // 3. Тип БВС
        if (entity.getDrone() != null) {
            dto.setAircraftType(entity.getDrone().getDroneName()); // или .getType(), в зависимости от структуры
        }

        // 4. Условия полета
        if (entity.getConditions() != null && !entity.getConditions().isEmpty()) {
            String conditionsStr = entity.getConditions()
                    .stream()
                    .map(Enum::name)
                    .collect(Collectors.joining(" / ")); // Пример: "О / АР / Т"
            dto.setFlightConditions(conditionsStr);
        }

        // 5. Ночной
        dto.setNightLabel(entity.isNight() ? "Да" : "Нет");

        // 6. Цель полета (пока как заглушка)
        dto.setFlightPurpose("Учебный"); // TODO: если появится поле в Entity, заменить

        // 7. ФИО студента
        if (entity.getStudent() != null) {
            dto.setStudentName(entity.getStudent().getFullName());
        }

        // 8. ФИО инструктора
        if (entity.getInstructor() != null) {
            dto.setInstructorName(entity.getInstructor().getFullName());
        }

        // 9. Локация (пока как заглушка)
        dto.setLocation("Центр подготовки"); // TODO: добавить поле в БД, если потребуется

        // 10. Результат (заглушка)
        dto.setResult("Зачтено"); // TODO: тоже может быть отдельным полем в будущем

        return dto;
     }
     */
}
