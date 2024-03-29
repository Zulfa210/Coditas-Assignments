package com.springrest.LDManagement.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "employment_type_details")
public class EmploymentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long employmentTypeId;
    @Column(nullable = false)
    private float employmentTypeHours;
    @OneToMany(mappedBy = "employmentType", cascade = CascadeType.ALL)
    private List<Trainer> trainerEmploymentTypes = new ArrayList<>();
    @Column(nullable = false)
    private String employmentType;

}
