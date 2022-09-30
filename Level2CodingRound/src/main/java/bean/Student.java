package bean;

import java.util.List;

/**
 * @author Zulfa Attar
 */
public class Student {
    private int studentId;
    private String studentName;
    private long studentMobileNo;
    private String studentCity;

    private List<Subject> subjectList;

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
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

    public long getStudentMobileNo() {
        return studentMobileNo;
    }

    public void setStudentMobileNo(long studentMobileNo) {
        this.studentMobileNo = studentMobileNo;
    }

    public String getStudentCity() {
        return studentCity;
    }

    public void setStudentCity(String studentCity) {
        this.studentCity = studentCity;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentMobileNo=" + studentMobileNo +
                ", studentCity='" + studentCity + '\'' +
                ", subjectList=" + subjectList +
                '}';
    }
}
