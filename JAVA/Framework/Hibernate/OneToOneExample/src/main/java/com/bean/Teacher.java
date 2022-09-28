package com.bean;

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
    private String teacherName;

    @OneToOne
    private Student student;

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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
