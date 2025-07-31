package com.aerosign.entity.primary;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "trainer")
public class Trainer {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "trainer_name", length = 25)
    private String trainerName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_student_id")
    private Student fkStudent;

    @Column(name = "is_available")
    private Boolean isAvailable;

    @Column(name = "student_name", length = 25)
    private String studentName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_classes_id")
    private Class fkClasses;

    @Column(name = "type", length = Integer.MAX_VALUE)
    private String type;

}