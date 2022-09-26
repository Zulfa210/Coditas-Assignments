package com.bean;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

/**
 * @author Zulfa Attar
 */
@Entity
@Table(name = "Teacher_new")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int teacherId;

    @Column(name = "teacher_name")
    private String teacherName;

    @Column(name = "teacher_designation")
    private String teacherDesignation;

    @Column(name = "teacher_city")
    private String teacherCity;

    @Column(name = "teacher_salary")
    private float teacherSalary;

    @ColumnDefault("000000000")
    private String teacherContactNo;

    public String getTeacherContactNo() {
        return teacherContactNo;
    }

    public void setTeacherContactNo(String teacherContactNo) {
        this.teacherContactNo = teacherContactNo;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherDesignation() {
        return teacherDesignation;
    }

    public void setTeacherDesignation(String teacherDesignation) {
        this.teacherDesignation = teacherDesignation;
    }

    public String getTeacherCity() {
        return teacherCity;
    }

    public void setTeacherCity(String teacherCity) {
        this.teacherCity = teacherCity;
    }

    public float getTeacherSalary() {
        return teacherSalary;
    }

    public void setTeacherSalary(float teacherSalary) {
        this.teacherSalary = teacherSalary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherDesignation='" + teacherDesignation + '\'' +
                ", teacherCity='" + teacherCity + '\'' +
                ", teacherSalary=" + teacherSalary +
                '}';
    }
}
