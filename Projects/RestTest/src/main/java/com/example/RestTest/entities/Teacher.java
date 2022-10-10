package com.example.RestTest.entities;

import javax.persistence.*;
import java.util.List;

/**
 * @author Zulfa Attar
 */

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacher_id")
    private int teacherId;

    @Column(name = "teacher_name")
    private String teacherName;

    @Column(name = "teacher_salary")
    private float teacherSalary;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Course> courses;

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

    public float getTeacherSalary() {
        return teacherSalary;
    }

    public void setTeacherSalary(float teacherSalary) {
        this.teacherSalary = teacherSalary;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Teacher() {
    }

    public Teacher(int teacherId, String teacherName, float teacherSalary, List<Course> courses) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherSalary = teacherSalary;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherSalary=" + teacherSalary +
                ", courses=" + courses +
                '}';
    }
}
