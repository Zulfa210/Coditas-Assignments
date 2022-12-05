package com.coditas.SpringBootTesting.controller;

import com.coditas.SpringBootTesting.entity.Student;
import com.coditas.SpringBootTesting.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Zulfa Attar
 */
@RestController
public class StudentController {

    @Autowired
    StudentService service;

    public StudentController() {
    }

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/getStudents")
    public ResponseEntity getAllStudents(){
        try{
            List<Student> students = service.getAllStudents();
            if(students.isEmpty()){
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity(students, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
