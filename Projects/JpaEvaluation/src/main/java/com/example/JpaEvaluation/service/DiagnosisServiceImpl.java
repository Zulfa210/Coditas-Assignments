package com.example.JpaEvaluation.service;

import com.example.JpaEvaluation.entities.Diagnosis;
import com.example.JpaEvaluation.entities.Patient;
import com.example.JpaEvaluation.entities.Test;
import com.example.JpaEvaluation.repository.DiagnosisRepository;
import com.example.JpaEvaluation.repository.PatientRepository;
import com.example.JpaEvaluation.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zulfa Attar
 */
@Service
public class DiagnosisServiceImpl implements DiagnosisService{

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    TestRepository testRepository;

    @Autowired
    DiagnosisRepository diagnosisRepository;

    @Override
    public Diagnosis getDiagnosis(long patientId) {

        Patient patient = patientRepository.findById(patientId).orElse(null);
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setPatient(patient);
        List<Test> tests = new ArrayList<>();

         float patientBmi = patient.getPatientBmi();
         float patientBloodPressure= patient.getPatientBloodPressure();
         float patientHeartBeat= patient.getPatientHeartBeat();
         float patientSpo2 = patient.getPatientSpo2();

         List<Test> availableTests = testRepository.findAll();

         String[] testParameters = {"BMI", "heart_beat", "Spo2", "Blood_Pressure"}  ;

             for (Test test : availableTests) {
                 if (test.getTestParameter().equalsIgnoreCase("BMI")) {
                     if (patientBmi > test.getTestMaxValue() || patientBmi < test.getTestMinValue()) {
                         tests.add(test);
                     }
                 }
                 if (test.getTestParameter().equalsIgnoreCase("heart_beat")) {
                     if (patientHeartBeat > test.getTestMaxValue() || patientHeartBeat < test.getTestMinValue()) {
                         tests.add(test);
                     }
                 }
                 if (test.getTestParameter().equalsIgnoreCase("Spo2")) {
                     if (patientSpo2 > test.getTestMaxValue() || patientSpo2 < test.getTestMinValue()) {
                         tests.add(test);
                     }
                 }
                 if (test.getTestParameter().equalsIgnoreCase("Blood_Pressure")) {
                     if (patientBloodPressure > test.getTestMaxValue() || patientBloodPressure < test.getTestMinValue()) {
                         tests.add(test);
                     }
                 }
             }


            diagnosis.setTestsList(tests);
        return diagnosisRepository.save(diagnosis);
    }
}
