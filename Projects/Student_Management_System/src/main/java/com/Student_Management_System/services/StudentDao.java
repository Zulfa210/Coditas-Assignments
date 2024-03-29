package com.Student_Management_System.services;

import com.Student_Management_System.entities.Address;
import com.Student_Management_System.entities.Student;

import java.util.List;

/**
 * @author Zulfa Attar
 */
public interface StudentDao {
    public void registerStudent(Student student);
    public void deleteStudent(int studentEnrollmentId);

    public List<Student> showAllStudents();

    public void updateStudent(Student student);

}
