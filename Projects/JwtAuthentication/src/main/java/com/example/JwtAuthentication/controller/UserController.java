package com.example.JwtAuthentication.controller;

import com.example.JwtAuthentication.entities.User;
import com.example.JwtAuthentication.repository.UserRepository;
import com.example.JwtAuthentication.request.JwtRequest;
import com.example.JwtAuthentication.response.JwtResponse;
import com.example.JwtAuthentication.util.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * @author Zulfa Attar
 */
@RestController
public class UserController {


    @Autowired
    private JwtUtility jwtUtility;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    UserRepository userRepository;


    @PostMapping("/login")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUserEmail(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException badCredentialsException) {
            throw new Exception("INVALID_CREDENTIAL", badCredentialsException);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUserEmail());
        final String token = jwtUtility.generateToken(userDetails);
        //final String userRole = userRepository.findByUserEmail(jwtRequest.getUserEmail()).getUserRole();
        final long userId = userRepository.findByUserEmail(jwtRequest.getUserEmail()).getUserId();
            return new JwtResponse( token, userId);

    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody User user){
        try{
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String password = passwordEncoder.encode(user.getPassword());
            user.setPassword(password);
            if(user.getUserRole().equalsIgnoreCase("user")){
                user.setUserRole("user");
            }else if(user.getUserRole().equalsIgnoreCase("admin")){
               return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
            }
            return new ResponseEntity(userRepository.save(user), HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
