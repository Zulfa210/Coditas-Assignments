package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Zulfa Attar
 */
@Entity
@Table(name = "student_emb")
public class Student {
    @Id
    private int studentId;
    private String studentName;
    private String contactNo;

    private Address address;

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

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Student(int studentId, String studentName, String contactNo, Address address) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.contactNo = contactNo;
        this.address = address;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", address=" + address +
                '}';
    }
}
