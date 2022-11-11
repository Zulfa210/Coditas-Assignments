package com.springrest.LDManagement.service;

import com.springrest.LDManagement.entities.Student;
import com.springrest.LDManagement.model.dto.StudentDto;

import java.util.List;

/**
 * @author Zulfa Attar
 */
public interface StudentService {

    public Student createStudent(StudentDto studentDto);
    public int updateStudent(Student student);
    public List<Student> getStudents();

    void deleteStudent(Long studentId);
}
