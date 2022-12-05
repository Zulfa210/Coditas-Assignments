package com.coditas.SpringBootTesting.service;

import com.coditas.SpringBootTesting.entity.Student;
import com.coditas.SpringBootTesting.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Zulfa Attar
 */
@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        this.studentService = new StudentServiceImpl(this.studentRepository);
    }

    @Test
    void getAllStudents() {


        studentService.getAllStudents();
        verify(studentRepository).findAll();
    }

    @Test
    void canAddStudent(){
        Student student = new Student();
        student.setStudentName("Zulfa");
        student.setStudentCity("Pune");
        studentService.addStudent(student);

        ArgumentCaptor<Student> studentArgumentCaptor =
                ArgumentCaptor.forClass(Student.class);

        verify(studentRepository).save(studentArgumentCaptor.capture());

        Student capturedStudent = studentArgumentCaptor.getValue();
        assertThat(student).isEqualTo(capturedStudent);
    }

    @Test
    void canUpdateStudent(){

    }
}