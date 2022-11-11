package com.example.JpaEvaluation.service;

import com.example.JpaEvaluation.entities.TestResults;
import com.example.JpaEvaluation.model.dto.TestResultDto;

/**
 * @author Zulfa Attar
 */
public interface TestResultService {

    public TestResults getResults(long diagnosisId);

    public TestResults addResult(TestResultDto testResultDto);
}
