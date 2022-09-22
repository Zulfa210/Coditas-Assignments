package com.bean;

/**
 * @author Zulfa Attar
 */
public class Student {
    int studentId;
    String studentName;
    String mobileNo;
    String studentCity;
    float studentPercentage;

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", studentCity='" + studentCity + '\'' +
                ", studentPercentage=" + studentPercentage +
                '}';
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

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getStudentCity() {
        return studentCity;
    }

    public void setStudentCity(String studentCity) {
        this.studentCity = studentCity;
    }

    public float getStudentPercentage() {
        return studentPercentage;
    }

    public void setStudentPercentage(float studentPercentage) {
        this.studentPercentage = studentPercentage;
    }
}
