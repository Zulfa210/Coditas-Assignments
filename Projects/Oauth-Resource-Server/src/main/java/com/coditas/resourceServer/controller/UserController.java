package com.coditas.resourceServer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zulfa Attar
 */
@RestController
public class UserController {

    @GetMapping("/api/users")
    public String[] getUsers(){
        return new String[]{"Zulfa", "Dev", "Anuj"};
    }
}
