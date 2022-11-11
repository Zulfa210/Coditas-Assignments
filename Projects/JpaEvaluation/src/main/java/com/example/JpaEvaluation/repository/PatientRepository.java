package com.example.JpaEvaluation.repository;

import com.example.JpaEvaluation.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Zulfa Attar
 */

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
