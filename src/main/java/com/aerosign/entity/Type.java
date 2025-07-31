package com.aerosign.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_id_gen")
    @SequenceGenerator(name = "type_id_gen", sequenceName = "type_type_id_seq", allocationSize = 1)
    @Column(name = "type_id", nullable = false)
    private Long id;

    @Column(name = "type_trainer", nullable = false, length = 100)
    private String typeTrainer;

}