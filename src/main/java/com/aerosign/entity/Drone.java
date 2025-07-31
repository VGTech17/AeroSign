package com.aerosign.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "drones")
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "drones_id_gen")
    @SequenceGenerator(name = "drones_id_gen", sequenceName = "drones_drone_id_seq", allocationSize = 1)
    @Column(name = "drone_id", nullable = false)
    private Integer id;

    @Column(name = "drone_name", nullable = false, length = 25)
    private String droneName;

    @ColumnDefault("true")
    @Column(name = "is_available")
    private Boolean isAvailable;

    @Column(name = "name", length = 25)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_classes_id")
    private Class fkClasses;

}