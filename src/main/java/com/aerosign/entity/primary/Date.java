package com.aerosign.entity.primary;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "dates")
public class Date {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dates_id_gen")
    @SequenceGenerator(name = "dates_id_gen", sequenceName = "dates_date_id_seq", allocationSize = 1)
    @Column(name = "date_id", nullable = false)
    private Integer id;

    @Column(name = "time_start", nullable = false)
    private Instant timeStart;

    @Column(name = "time_stop")
    private Instant timeStop;

    @Column(name = "student_name", length = 25)
    private String studentName;

    @Column(name = "drone_name", length = 25)
    private String droneName;

    @Column(name = "comment")
    private String comment;
    @Column(name = "student_id")
    private Integer studentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Instant timeStart) {
        this.timeStart = timeStart;
    }

    public Instant getTimeStop() {
        return timeStop;
    }

    public void setTimeStop(Instant timeStop) {
        this.timeStop = timeStop;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDroneName() {
        return droneName;
    }

    public void setDroneName(String droneName) {
        this.droneName = droneName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}