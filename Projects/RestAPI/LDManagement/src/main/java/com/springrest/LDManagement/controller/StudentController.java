package com.springrest.LDManagement.controller;

import com.springrest.LDManagement.entities.Feedback;
import com.springrest.LDManagement.entities.Student;
import com.springrest.LDManagement.service.FeedbackServiceImplementation;
import com.springrest.LDManagement.service.StudentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentServiceImplementation studentServiceImplementation;

    @Autowired
    FeedbackServiceImplementation feedbackServiceImplementation;

    @PostMapping("/giveFeedback")
    public ResponseEntity giveFeedback(@RequestBody Feedback feedback) {
        try {
            return new ResponseEntity(Optional.of(feedbackServiceImplementation.giveFeedback(feedback)).orElse(null), HttpStatus.OK);
        }
        catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getStudent/{studentId}")
    public ResponseEntity getTrainer(@PathVariable String studentId) {
        try {
            Student student = studentServiceImplementation.getStudent(Long.parseLong(studentId));
            if (student != null) {
                return new ResponseEntity(student, HttpStatus.OK);
            }
            else {
                return new ResponseEntity(null, HttpStatus.NO_CONTENT);
            }
        }
        catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}