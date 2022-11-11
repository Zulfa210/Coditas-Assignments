package com.springrest.LDManagement.entities;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "trainer_details")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long trainerId;

    @Column(nullable = false)
    private String trainerName;

    @Column(nullable = false)
    private String trainerEmail;

    @Column(nullable = false)
    private float trainerSalary;

    @OneToMany(mappedBy = "studentTrainer", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainer_employment_type")
    private EmploymentType employmentType;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainer_domain")
    private Domain domain;
    @ColumnDefault(value = "false")
    private boolean isDeleted;

}
