package com.example.JpaEvaluation.service;

import com.example.JpaEvaluation.entities.Diagnosis;

/**
 * @author Zulfa Attar
 */
public interface DiagnosisService {
    public Diagnosis getDiagnosis(long patientId);
}
