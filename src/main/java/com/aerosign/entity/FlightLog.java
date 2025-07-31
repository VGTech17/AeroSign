package com.aerosign.entity;

import com.aerosign.enums.DroneType;
import com.aerosign.enums.FlightCondition;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class FlightLog {

    // Л Е Т Н А Я  К Н И Ж К А
    //внешнего пилота и (или) оператора беспилотного воздушного судна
    //с максимальной взлетной массой 30 килограммов и менее.

    private String studentName;              // Студент ФИО


    // Поля под Раздел 1.
    private LocalDate flightDate;            // Дата полета
    private DroneType droneType;                // Вид БВС (M(4), С, В и т.д.)
    private Set<FlightCondition> flightConditions;    // Условия (Т, П, И/В)
    private int flightCount;                 // Кол-во полетов
    private double dayDuration;              // Налёт день (часы.минуты)
    private double nightDuration;            // Налёт ночь
    private double totalDuration;            // Общий налёт


    private String instructorName;           // Инструктор
    private String comment;                  // Комментарий (результат)
    private boolean isExternalPilot;         // Признак внешнего пилота


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    public DroneType getDroneType() {
        return droneType;
    }

    public void setDroneType(DroneType droneType) {
        this.droneType = droneType;
    }

    public Set<FlightCondition> getFlightConditions() {
        return flightConditions;
    }

    public void setFlightConditions(Set<FlightCondition> flightConditions) {
        this.flightConditions = flightConditions;
    }

    public int getFlightCount() {
        return flightCount;
    }

    public void setFlightCount(int flightCount) {
        this.flightCount = flightCount;
    }

    public double getDayDuration() {
        return dayDuration;
    }

    public void setDayDuration(double dayDuration) {
        this.dayDuration = dayDuration;
    }

    public double getNightDuration() {
        return nightDuration;
    }

    public void setNightDuration(double nightDuration) {
        this.nightDuration = nightDuration;
    }

    public double getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(double totalDuration) {
        this.totalDuration = totalDuration;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isExternalPilot() {
        return isExternalPilot;
    }

    public void setExternalPilot(boolean externalPilot) {
        isExternalPilot = externalPilot;
    }

    @Override
    public String toString() {
        return "FlightLog{" +
                "flightDate=" + flightDate +
                ", droneType='" + droneType + '\'' +
                ", flightConditions=" + flightConditions +
                ", flightCount=" + flightCount +
                ", dayDuration=" + dayDuration +
                ", nightDuration=" + nightDuration +
                ", totalDuration=" + totalDuration +
                ", studentName='" + studentName + '\'' +
                ", instructorName='" + instructorName + '\'' +
                ", comment='" + comment + '\'' +
                ", isExternalPilot=" + isExternalPilot +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightLog)) return false;
        FlightLog flightLog = (FlightLog) o;
        return flightCount == flightLog.flightCount &&
                Double.compare(flightLog.dayDuration, dayDuration) == 0 &&
                Double.compare(flightLog.nightDuration, nightDuration) == 0 &&
                Double.compare(flightLog.totalDuration, totalDuration) == 0 &&
                isExternalPilot == flightLog.isExternalPilot &&
                Objects.equals(flightDate, flightLog.flightDate) &&
                Objects.equals(droneType, flightLog.droneType) &&
                Objects.equals(flightConditions, flightLog.flightConditions) &&
                Objects.equals(studentName, flightLog.studentName) &&
                Objects.equals(instructorName, flightLog.instructorName) &&
                Objects.equals(comment, flightLog.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightDate, droneType, flightConditions, flightCount, dayDuration, nightDuration,
                totalDuration, studentName, instructorName, comment, isExternalPilot);
    }
}