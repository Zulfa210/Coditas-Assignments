package com.example.JpaEvaluation.repository;

import com.example.JpaEvaluation.entities.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Zulfa Attar
 */
@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {
}
