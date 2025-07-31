package com.aerosign.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "students_id_gen")
    @SequenceGenerator(name = "students_id_gen", sequenceName = "students_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 25)
    private String studentName; // переименовл с name

    @Column(name = "group_name", nullable = false, length = 25)
    private String groupName;

    @Column(name = "tg_id")
    private Long tgId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_dron_id")
    private Drone fkDron;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_date_id")
    private Date fkDate;

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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Long getTgId() {
        return tgId;
    }

    public void setTgId(Long tgId) {
        this.tgId = tgId;
    }

    public Drone getFkDron() {
        return fkDron;
    }

    public void setFkDron(Drone fkDron) {
        this.fkDron = fkDron;
    }

    public Date getFkDate() {
        return fkDate;
    }

    public void setFkDate(Date fkDate) {
        this.fkDate = fkDate;
    }
}