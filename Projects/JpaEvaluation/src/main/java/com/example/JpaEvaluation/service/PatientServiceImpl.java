package com.example.JpaEvaluation.service;

import com.example.JpaEvaluation.entities.Patient;
import com.example.JpaEvaluation.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Zulfa Attar
 */
@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    PatientRepository patientRepository;

    @Override
    public Patient addPatient(Patient patient) {

        float heightInMeters = patient.getPatientHeight()/100;
        float bmi = patient.getPatientWeight()/(heightInMeters * heightInMeters);
        patient.setPatientBmi(bmi);
        return patientRepository.save(patient);
    }
}
