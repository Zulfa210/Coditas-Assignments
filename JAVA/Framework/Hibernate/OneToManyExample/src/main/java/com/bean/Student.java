package com.bean;

import javax.persistence.*;
import java.util.List;

/**
 * @author Zulfa Attar
 */
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private int studentId;

    @Column(name="student_name")
    private String studentName;

    @Column(name = "student_class")
    private String studentClass;

    @OneToMany(mappedBy = "student")
    private List<Address> studentAddress;

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

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public List<Address> getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(List<Address> studentAddress) {
        this.studentAddress = studentAddress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "\nstudentId=" + studentId +
                "\n studentName='" + studentName + '\'' +
                "\n studentClass='" + studentClass + '\'' +
                "\n studentAddress=" + studentAddress +
                '}';
    }
}
