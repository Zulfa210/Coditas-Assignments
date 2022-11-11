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
public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long diagnosisId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Patient patient;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    @JoinTable(joinColumns = @JoinColumn(name = "diagnosis_id", referencedColumnName = "diagnosisId"),
    inverseJoinColumns = @JoinColumn(name = "test_id", referencedColumnName = "testId"))
    private List<Test> testsList;

    @JsonIgnore
    @OneToOne(mappedBy = "diagnosis")
    private  TestResults testResults;
}
