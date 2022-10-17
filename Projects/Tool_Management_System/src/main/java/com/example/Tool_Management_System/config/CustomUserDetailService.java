package com.example.Tool_Management_System.config;

/**
 * @author Zulfa Attar
 */

import com.example.Tool_Management_System.entities.User;
import com.example.Tool_Management_System.model.CustomerUserDetails;
import com.example.Tool_Management_System.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private WorkRepository workRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= workRepository.findByUsername(username);
        System.out.println(user);
        System.out.println(user.getUsername()+"   "+user.getPassword()+"  "+user.getRole());
        if(user==null)
            throw  new UsernameNotFoundException("User Not Found");
        return new CustomerUserDetails(user);
    }
}
