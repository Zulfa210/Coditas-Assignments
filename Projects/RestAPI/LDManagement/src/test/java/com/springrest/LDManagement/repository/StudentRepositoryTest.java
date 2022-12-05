package com.springrest.LDManagement.repository;

import com.springrest.LDManagement.entities.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Zulfa Attar
 */
@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository repositoryUnderTest;

    @AfterEach
    void tearDown() {
        repositoryUnderTest.deleteAll();
    }

    @Test
    void itShouldFindIdByStudentEmail() {

        Student student = new Student();
        student.setStudentName("Zulfa");
        student.setStudentEmail("zulfa@gmail.com");
        student.setDeleted(false);

        repositoryUnderTest.save(student);

        boolean expected = repositoryUnderTest.existsByStudentEmail("zulfa@gmail.com");

        //then
        assertThat(expected).isTrue();

    }

    @Test
    void itShouldCheckIfStudentDoesNotExist() {

        boolean expected = repositoryUnderTest.existsByStudentEmail("zulfa@gmail.com");

        //then
        assertThat(expected).isFalse();

    }

    @Test
    void getByStudentId() {

    }
}