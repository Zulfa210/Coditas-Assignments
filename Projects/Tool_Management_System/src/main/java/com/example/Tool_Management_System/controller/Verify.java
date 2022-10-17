package com.example.Tool_Management_System.controller;

/**
 * @author Zulfa Attar
 */
import com.example.Tool_Management_System.config.CustomUserDetailService;
import com.example.Tool_Management_System.model.CustomerUserDetails;
import com.example.Tool_Management_System.model.JwtRequest;
import com.example.Tool_Management_System.model.JwtResponse;
import com.example.Tool_Management_System.util.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
public class Verify {
    @Autowired
    private JwtUtility jwtUtility;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;


    // @PostMapping("/authenticate")
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{
        try{
            System.out.println(jwtRequest);
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        }catch(BadCredentialsException badCredentialsException){
            throw  new Exception("INVALID_CREDENTIAL",badCredentialsException);
        }
        final UserDetails userDetails=userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        System.out.println(userDetails);
        final String token=jwtUtility.generateToken(userDetails);
        System.out.println(token);

        return new JwtResponse(token);
    }
}