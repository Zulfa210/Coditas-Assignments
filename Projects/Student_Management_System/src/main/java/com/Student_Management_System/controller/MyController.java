package com.Student_Management_System.controller;

import com.Student_Management_System.entities.Student;
import com.Student_Management_System.services.StudentDaoImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zulfa Attar
 */
@RestController
@CrossOrigin
public class MyController {

    StudentDaoImplementation operations = new StudentDaoImplementation();

    @PostMapping("/insert")
    public void insertStudent(@RequestBody Student student){
        operations.registerStudent(student);
    }

    @GetMapping("/showStudents")
    public List<Student> displayStudent(){
        return operations.showAllStudents();
    }

    @DeleteMapping("/deleteStudent/{studentID}")
    public void deleteStudent(@PathVariable int studentId){

    }
}
