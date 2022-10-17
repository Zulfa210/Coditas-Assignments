package com.example.CarPassengerManagementSystem.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Zulfa Attar
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username.equals("Zulfa")){
            return  new User("Zulfa", "zulfa123", new ArrayList<>());
        }else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
