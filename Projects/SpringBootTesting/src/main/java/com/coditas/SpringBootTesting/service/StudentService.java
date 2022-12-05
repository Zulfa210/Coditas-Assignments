package com.coditas.SpringBootTesting.service;

import com.coditas.SpringBootTesting.entity.Student;

import java.util.List;

/**
 * @author Zulfa Attar
 */
public interface StudentService {
    public List<Student> getAllStudents();

    public Student addStudent(Student student);

    public Student updateStudent(Student student);

    public int deleteStudent(long studentId);
}
