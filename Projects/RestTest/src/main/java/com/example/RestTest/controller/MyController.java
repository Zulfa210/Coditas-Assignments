package com.example.RestTest.controller;

import com.example.RestTest.entities.Teacher;
import com.example.RestTest.service.DaoOperations;
import com.example.RestTest.service.DaoOperationsImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.List;

/**
 * @author Zulfa Attar
 */
@CrossOrigin
@RestController
public class MyController {

    @Autowired
DaoOperations daoOperations;


    @CrossOrigin
    @GetMapping("/showTeachers")
    public List<Teacher> fetchTeachers(){
        return daoOperations.showTeachers();
    }


    @PostMapping("/insert")
    public void insertTeacher(@RequestBody Teacher teacher){
        daoOperations.insertTeacher(teacher);
    }

    @CrossOrigin
    @PutMapping("/update")
    public void update(@RequestBody Teacher teacher){
        daoOperations.updateTeacher(teacher);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        daoOperations.deleteTeacher(id);
    }


}
