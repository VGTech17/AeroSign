package com.aerosign.entity.primary;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "classes")
public class Class {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "class_name")
    private String className;

}