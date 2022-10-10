package com.Student_Management_System.controller;

import com.Student_Management_System.entities.Address;
import com.Student_Management_System.entities.Student;
import com.Student_Management_System.services.StudentDao;
import com.Student_Management_System.services.StudentDaoImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author Zulfa Attar
 */
@RestController
@CrossOrigin
public class MyController {

    @Autowired
    StudentDao operations;

    @CrossOrigin
    @PostMapping("/insert")
    public void insertStudent(@RequestBody Student student){
        operations.registerStudent(student);
    }

    @CrossOrigin
    @GetMapping("/showStudents")
    public List<Student> displayStudent(){


        List<Student> students = operations.showAllStudents();
//        HashMap<String, List> dataMap = new HashMap<>();
//        if(students!= null) {
//            dataMap.put("data", students);
//            dataMap.put("error", null);
//        }
//        else {
//            dataMap.put("data", null);
//            dataMap.put("error", Collections.singletonList(new ArrayList().add("Invalid URL")));
//        }
        //return ResponseEntity.of(Optional.of(students));
        return students;
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteStudent/{studentEnrollmentId}", method = RequestMethod.DELETE)
//    @DeleteMapping("/deleteStudent/{studentEnrollmentId}")
    public void deleteStudent(@PathVariable int studentEnrollmentId){
         operations.deleteStudent(studentEnrollmentId);
    }

    @CrossOrigin
    @PutMapping("/update")
    public void updateStudent(@RequestBody Student student){
        operations.updateStudent(student);
    }

    @CrossOrigin
    @RequestMapping(value = "/**")
    public HashMap invalidUrl(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("data", null);
        hashMap.put("error", "Invalid URL");

        return hashMap;
    }
}