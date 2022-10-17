package com.example.CarPassengerManagementSystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zulfa Attar
 */
@RestController
public class MyController {

@RequestMapping("/welcome")
    public String welcome(){
    return "This is a private page";
}
}
