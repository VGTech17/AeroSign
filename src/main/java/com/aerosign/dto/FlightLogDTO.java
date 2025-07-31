package com.aerosign.dto;

public class FlightLogDTO {

    private String dateFormatted;              // 27.07.2025

    private String flightTimeFormatted;        // 1 ч 30 мин

    private String aircraftType;

    private String flightConditions;

    private String nightLabel;                 // "Да" / "Нет"

    private String flightPurpose;

    private String studentName;

    private String instructorName;

    private String location;

    private String result;

    // Конструкторы
    public FlightLogDTO() {
    }

    public FlightLogDTO(String dateFormatted, String flightTimeFormatted, String aircraftType, String flightConditions, String nightLabel, String flightPurpose, String studentName, String instructorName, String location, String result) {
        this.dateFormatted = dateFormatted;
        this.flightTimeFormatted = flightTimeFormatted;
        this.aircraftType = aircraftType;
        this.flightConditions = flightConditions;
        this.nightLabel = nightLabel;
        this.flightPurpose = flightPurpose;
        this.studentName = studentName;
        this.instructorName = instructorName;
        this.location = location;
        this.result = result;
    }

    public String getDateFormatted() {
        return dateFormatted;
    }

    public void setDateFormatted(String dateFormatted) {
        this.dateFormatted = dateFormatted;
    }

    public String getFlightTimeFormatted() {
        return flightTimeFormatted;
    }

    public void setFlightTimeFormatted(String flightTimeFormatted) {
        this.flightTimeFormatted = flightTimeFormatted;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public String getFlightConditions() {
        return flightConditions;
    }

    public void setFlightConditions(String flightConditions) {
        this.flightConditions = flightConditions;
    }

    public String getNightLabel() {
        return nightLabel;
    }

    public void setNightLabel(String nightLabel) {
        this.nightLabel = nightLabel;
    }

    public String getFlightPurpose() {
        return flightPurpose;
    }

    public void setFlightPurpose(String flightPurpose) {
        this.flightPurpose = flightPurpose;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
