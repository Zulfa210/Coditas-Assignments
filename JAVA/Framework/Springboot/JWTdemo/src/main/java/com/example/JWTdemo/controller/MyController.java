package com.example.JWTdemo.controller;

import com.example.JWTdemo.model.JwtRequest;
import com.example.JWTdemo.model.JwtResponse;
import com.example.JWTdemo.service.MyUserDetailsService;
import com.example.JWTdemo.util.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * @author Zulfa Attar
 */
@RestController
public class MyController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtility jwtUtility;

    @RequestMapping("/hello")
    public String greet(){
        return "Hello User";
    }

    @RequestMapping(value = "/authenticate" , method = RequestMethod.POST)
    public ResponseEntity createToken(@RequestBody JwtRequest jwtRequest){
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword())
            );
        }catch (Exception e){
            e.printStackTrace();
        }
        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
        final String jwtToken = jwtUtility.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(jwtToken));
    }
}
