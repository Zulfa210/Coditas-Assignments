package com.example.JpaEvaluation.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author Zulfa Attar
 */
@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long patientId;

    private String patientName;
    private int patientAge;
    private float patientHeight;
    private float patientWeight;
    private float patientBmi;
    private float patientBloodPressure;
    private float patientHeartBeat;
    private float patientSpo2;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private List<Diagnosis> diagnosisList;

}
