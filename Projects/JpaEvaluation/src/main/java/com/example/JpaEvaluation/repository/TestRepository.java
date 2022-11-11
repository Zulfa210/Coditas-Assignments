package com.example.JpaEvaluation.repository;

import com.example.JpaEvaluation.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Zulfa Attar
 */
@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
}
