package com.Student_Management_System.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * @author Zulfa Attar
 */

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentEnrollmentId;
    private int studentRollNo;
    private String studentFirstName;
    private String studentLastName;
    private String studentGender;
    private Date studentDateOfBirth;
    private String studentDepartment;
    private String studentClass;

    private Address studentTemporaryAddress;
    private Address studentPermanentAddress;

    public int getStudentEnrollmentId() {
        return studentEnrollmentId;
    }

    public void setStudentEnrollmentId(int studentEnrollmentId) {
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

    public Address getStudentPermanentAddress() {
        return studentPermanentAddress;
    }

    public void setStudentPermanentAddress(Address studentPermanentAddress) {
        this.studentPermanentAddress = studentPermanentAddress;
    }
}
