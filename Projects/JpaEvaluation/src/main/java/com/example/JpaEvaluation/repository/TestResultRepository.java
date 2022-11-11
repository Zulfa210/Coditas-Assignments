package com.example.JpaEvaluation.repository;

import com.example.JpaEvaluation.entities.Diagnosis;
import com.example.JpaEvaluation.entities.TestResults;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Zulfa Attar
 */
public interface TestResultRepository extends JpaRepository<TestResults, Long> {
    TestResults findByDiagnosis(Diagnosis diagnosis);
}
