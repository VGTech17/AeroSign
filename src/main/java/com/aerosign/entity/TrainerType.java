package com.aerosign.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "trainer_type")
public class TrainerType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trainer_type_id_gen")
    @SequenceGenerator(name = "trainer_type_id_gen", sequenceName = "trainer_type_create_id_seq", allocationSize = 1)
    @Column(name = "trainer_type_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

}