package com.aerosign.enums;

public enum DroneType {
    FIXED_WING("С — самолетного типа"),
    ROTORCRAFT("В — вертолетного типа"),
    MULTIROTOR_4("М(4) — мультироторный тип (4 винта)"),
    VTOL("СВ — самолетного типа с вертикальным взлетом"),
    HEAVY_EXTERNAL_PILOT("С* — внешний пилот БВС >30 кг"),
    UNKNOWN("Неизвестный тип");

    private final String description;

    DroneType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
