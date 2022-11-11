package com.springrest.LDManagement.model.dto;

import com.springrest.LDManagement.entities.Domain;
import com.springrest.LDManagement.entities.Trainer;

/**
 * @author Zulfa Attar
 */
public class StudentDto {
    private Long studentId;
    private String studentName;
    private String studentEmail;
    private Domain studentDomain;
    private Trainer studentTrainer;
    private boolean isDeleted;
    private String studentPassword;

    public StudentDto() {
    }

    public StudentDto(Long studentId, String studentName, String studentEmail, Domain studentDomain, Trainer studentTrainer, boolean isDeleted, String studentPassword) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentDomain = studentDomain;
        this.studentTrainer = studentTrainer;
        this.isDeleted = isDeleted;
        this.studentPassword = studentPassword;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public Domain getStudentDomain() {
        return studentDomain;
    }

    public void setStudentDomain(Domain studentDomain) {
        this.studentDomain = studentDomain;
    }

    public Trainer getStudentTrainer() {
        return studentTrainer;
    }

    public void setStudentTrainer(Trainer studentTrainer) {
        this.studentTrainer = studentTrainer;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }
}
