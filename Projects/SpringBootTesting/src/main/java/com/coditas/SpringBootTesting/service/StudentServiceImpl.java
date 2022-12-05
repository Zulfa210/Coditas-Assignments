package com.coditas.SpringBootTesting.service;

import com.coditas.SpringBootTesting.entity.Student;
import com.coditas.SpringBootTesting.repository.StudentRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zulfa Attar
 */
@NoArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {

        Student existingStudent = studentRepository.findById(student.getStudentId()).orElse(null);
        if(existingStudent != null){
            existingStudent.setStudentCity(student.getStudentName());
            existingStudent.setStudentName(student.getStudentCity());
            return studentRepository.save(existingStudent);
        }
        return null;
    }

    @Override
    public int deleteStudent(long studentId) {

        Student existingStudent = studentRepository.findById(studentId).orElse(null);
        if(existingStudent!= null){
            studentRepository.deleteById(studentId);
            return 1;
        }
        return 0;
    }


}
