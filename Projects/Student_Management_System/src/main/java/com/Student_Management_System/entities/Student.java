package com.Student_Management_System.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Zulfa Attar
 */

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_EnrollmentId")
    @NotNull
    private Integer studentEnrollmentId;


    @Column(name = "student_roll_no")
    @NotNull
    private int studentRollNo;

    @Column(name = "student_first_name")
    private String studentFirstName;

    @Column(name = "student_last_name")
    private String studentLastName;

    @Column(name = "student_gender")
    private String studentGender;

    @Column(name = "student_dob")
    private Date studentDateOfBirth;

    @Column(name = "student_department")
    private String studentDepartment;

    @Column(name = "student_class")
    private String studentClass;

    @ManyToOne(cascade = CascadeType.ALL)
    private Address studentTemporaryAddress;

    public Student() {
    }

    public Student(Integer studentEnrollmentId, int studentRollNo, String studentFirstName, String studentLastName, String studentGender, Date studentDateOfBirth, String studentDepartment, String studentClass, Address studentTemporaryAddress) {
        this.studentEnrollmentId = studentEnrollmentId;
        this.studentRollNo = studentRollNo;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentGender = studentGender;
        this.studentDateOfBirth = studentDateOfBirth;
        this.studentDepartment = studentDepartment;
        this.studentClass = studentClass;
        this.studentTemporaryAddress = studentTemporaryAddress;
    }

    public Integer getStudentEnrollmentId() {
        return studentEnrollmentId;
    }

    public void setStudentEnrollmentId(Integer studentEnrollmentId) {
        this.studentEnrollmentId = studentEnrollmentId;
    }

    public int getStudentRollNo() {
        return studentRollNo;
    }

    public void setStudentRollNo(int studentRollNo) {
        this.studentRollNo = studentRollNo;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public Date getStudentDateOfBirth() {
        return studentDateOfBirth;
    }

    public void setStudentDateOfBirth(Date studentDateOfBirth) {
        this.studentDateOfBirth = studentDateOfBirth;
    }

    public String getStudentDepartment() {
        return studentDepartment;
    }

    public void setStudentDepartment(String studentDepartment) {
        this.studentDepartment = studentDepartment;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public Address getStudentTemporaryAddress() {
        return studentTemporaryAddress;
    }

    public void setStudentTemporaryAddress(Address studentTemporaryAddress) {
        this.studentTemporaryAddress = studentTemporaryAddress;
    }

}
