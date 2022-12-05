package com.springrest.LDManagement.service;

import com.springrest.LDManagement.entities.Domain;
import com.springrest.LDManagement.entities.Student;

import com.springrest.LDManagement.model.DTO.StudentDto;
import com.springrest.LDManagement.repository.DomainRepository;
import com.springrest.LDManagement.repository.StudentRepository;
import com.springrest.LDManagement.repository.UserRepository;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;

/**
 * @author Zulfa Attar
 */
@ExtendWith(MockitoExtension.class)
class StudentServiceImplementationTest {

    @Autowired
    private MockMvc mvc;

    @InjectMocks
    StudentServiceImplementation studentService;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private DomainRepository domainRepository;

    //private StudentServiceImplementation studentService;

    @BeforeEach
    void setUp() {
       // studentService = new StudentServiceImplementation(studentRepository,userRepository,domainRepository);

    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void canAddStudent() {
        StudentDto student = new StudentDto();
        student.setStudentName("Zulfa");
        student.setStudentEmail("zulfa@gmail.com");
        student.setStudentPassword("1234");
        student.setStudentId(1L);
        student.setDomainId(1L);

        Student student2 = new Student(null, "Zulfa", "zulfa@gmail.com", null, false);

        Mockito.when(domainRepository.findById(anyLong())).thenReturn(Optional.of(new Domain(1L, "Java", true)));
        Mockito.when(studentRepository.save(any())).thenReturn(student2);


        Student student1 = studentService.addStudent(student);
//        assertThat(student1).isEqualTo(student);
        ArgumentCaptor<Student> studentArgumentCaptor =
                ArgumentCaptor.forClass(Student.class);

        verify(studentRepository).save(studentArgumentCaptor.capture());

        Student capturedStudent = studentArgumentCaptor.getValue();
        System.out.println("===>" + student1);
        System.out.println("===>"+capturedStudent);
        assertThat(student1.getStudentId()).isEqualTo(capturedStudent.getStudentId());

    }

    @Disabled
    @Test
    void deleteStudent() {
    }

    @Test
    void canGetStudents() {
//        studentService.getStudents();
//        verify(studentRepository).findAll();


    }

    @Disabled
    @Test
    void updateStudent() {
    }

    @Disabled
    @Test
    void getStudent() {
    }
}