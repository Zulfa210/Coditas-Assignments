package com.springrest.LDManagement.service;

import com.springrest.LDManagement.entities.Student;
import com.springrest.LDManagement.entities.User;
import com.springrest.LDManagement.model.dto.StudentDto;
import com.springrest.LDManagement.repository.StudentRepository;
import com.springrest.LDManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zulfa Attar
 */
@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Student createStudent(StudentDto studentDto) {
        User user = new User();
        user.setEmail(studentDto.getStudentEmail());
        user.setPassword(studentDto.getStudentPassword());
        user.setRole("STUDENT");

        userRepository.save(user);

        Student student = new Student();
        student.setStudentName(studentDto.getStudentName());
        student.setStudentDomain(studentDto.getStudentDomain());
        student.setStudentEmail(studentDto.getStudentEmail());
        student.setDeleted(false);
        student.setStudentDomain(studentDto.getStudentDomain());
        student.setStudentTrainer(studentDto.getStudentTrainer());

        return studentRepository.save(student);
    }

    @Override
    public int updateStudent(Student student) {
        Student existingStudent  = studentRepository.findById(student.getStudentId()).orElse(null);
        if(existingStudent != null){
            studentRepository.save(student);
            User user= userRepository.findByEmail(existingStudent.getStudentEmail());
            user.setEmail(student.getStudentEmail());
            userRepository.save(user);

            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
