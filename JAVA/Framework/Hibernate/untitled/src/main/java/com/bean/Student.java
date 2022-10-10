package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Zulfa Attar
 */
@Entity
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;

    private String studentName;
    private String studentDepartment;

    public Student() {
    }

    public Student(int studentId, String studentName, String studentDepartment) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentDepartment = studentDepartment;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentDepartment() {
        return studentDepartment;
    }

    public void setStudentDepartment(String studentDepartment) {
        this.studentDepartment = studentDepartment;
    }
}
