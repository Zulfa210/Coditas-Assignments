package com.springrest.LDManagement.model.dto;

import com.springrest.LDManagement.entities.Domain;
import com.springrest.LDManagement.entities.EmploymentType;
import com.springrest.LDManagement.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zulfa Attar
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainerDto {

    private Long trainerId;
    private String trainerEmail;
    private String trainerPassword;
    private String trainerName;
    private float trainerSalary;
    private List<Student> students = new ArrayList<>();

    private EmploymentType employmentType;
    private Domain domain;
    private boolean isDeleted;
}
