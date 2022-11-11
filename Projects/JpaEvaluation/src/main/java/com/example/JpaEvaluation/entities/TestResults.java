package com.example.JpaEvaluation.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Map;

/**
 * @author Zulfa Attar
 */

@Entity
@Data
public class TestResults {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long testResultId;
    private String testComment;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name = "testResult_id", referencedColumnName = "testResultId"),
    inverseJoinColumns = @JoinColumn(name = "test_id", referencedColumnName = "testId"))
    private Map<Float, Test> testValues;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "diagnosis_id",
            referencedColumnName = "diagnosisId")
    private Diagnosis diagnosis;
}
