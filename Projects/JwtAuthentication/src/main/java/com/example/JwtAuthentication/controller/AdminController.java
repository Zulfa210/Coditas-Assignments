package com.example.JwtAuthentication.controller;

import com.example.JwtAuthentication.entities.User;
import com.example.JwtAuthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zulfa Attar
 */
@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    UserRepository userRepository;

    @GetMapping("/getUsers")
    public ResponseEntity getUsers(){
        try{
            List<User> users =  userRepository.findAll().stream().filter(user -> !(user.getUserRole().equalsIgnoreCase("admin"))).collect(Collectors.toList());
            if(users.size()>0) {
                return new ResponseEntity(users, HttpStatus.OK);
            }else {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
