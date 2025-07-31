package com.aerosign.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attendance_id_gen")
    @SequenceGenerator(name = "attendance_id_gen", sequenceName = "attendance_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "student_name", nullable = false, length = 25)
    private String studentName;

    @Column(name = "\"timestamp\"", nullable = false)
    private Instant timestamp;

    @Column(name = "end_timestamp")
    private Instant endTimestamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Instant getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(Instant endTimestamp) {
        this.endTimestamp = endTimestamp;
    }
}