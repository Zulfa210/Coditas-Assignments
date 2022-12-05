package com.coditas.SpringBootTesting.repository;

import com.coditas.SpringBootTesting.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Zulfa Attar
 */
@Repository
public interface StudentRepository extends JpaRepository <Student, Long> {

    boolean existsByStudentId(long studentId);


}
