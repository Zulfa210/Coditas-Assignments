package com.coditas.SpringBootTesting.repository;

import com.coditas.SpringBootTesting.entity.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Zulfa Attar
 */
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void existsByStudentId() {
        Student student = new Student();
        student.setStudentName("Zulfa");
        student.setStudentCity("Pune");
        studentRepository.save(student);

        Boolean actualResult = studentRepository.existsByStudentId(6);
        assertEquals(true, actualResult);


    }

    @AfterEach
    void tearDown() {
        System.out.println("Tearing Down");
        System.out.println(studentRepository.findAll());
        //studentRepository.deleteAll();
    }

    @BeforeEach
    void setUp() {
        System.out.println("Setting Up");
        System.out.println(studentRepository.findAll());
    }
}