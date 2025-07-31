package com.aerosign.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "teacher_attendance")
public class TeacherAttendance {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_attendance_id_gen")
    @SequenceGenerator(name = "teacher_attendance_id_gen", sequenceName = "teacher_attendance_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "teacher_name", nullable = false, length = 25)
    private String teacherName;

    @Column(name = "\"timestamp\"", nullable = false)
    private Instant timestamp;

    @Column(name = "end_timestamp")
    private Instant endTimestamp;

}