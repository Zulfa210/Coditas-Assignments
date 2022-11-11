package com.example.JpaEvaluation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author Zulfa Attar
 */
@Entity
@Data
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long testId;
    private String testName;
    private float testMaxValue;
    private float testMinValue;
    private String testParameter;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "testsList")
    private List<Diagnosis> diagnosis;
}




