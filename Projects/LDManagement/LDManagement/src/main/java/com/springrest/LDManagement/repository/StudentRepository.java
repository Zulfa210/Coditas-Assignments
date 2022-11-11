package com.springrest.LDManagement.repository;

import com.springrest.LDManagement.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Zulfa Attar
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long > {
}
