package com.aerosign.entity.primary;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teachers_id_gen")
    @SequenceGenerator(name = "teachers_id_gen", sequenceName = "teachers_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 25)
    private String teacherName; // переименовал с name

    @Column(name = "tg_id")
    private Long tgId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_dron_id")
    private Drone fkDron;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_date_id")
    private Date fkDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_tg_id", referencedColumnName = "tg_id")
    private Student fkTg;

    @ColumnDefault("false")
    @Column(name = "has_marked_attendance")
    private Boolean hasMarkedAttendance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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

    public Student getFkTg() {
        return fkTg;
    }

    public void setFkTg(Student fkTg) {
        this.fkTg = fkTg;
    }

    public Boolean getHasMarkedAttendance() {
        return hasMarkedAttendance;
    }

    public void setHasMarkedAttendance(Boolean hasMarkedAttendance) {
        this.hasMarkedAttendance = hasMarkedAttendance;
    }
}