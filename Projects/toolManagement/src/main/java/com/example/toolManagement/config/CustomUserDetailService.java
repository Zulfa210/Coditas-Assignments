package com.example.toolManagement.config;

/**
 * @author Zulfa Attar
 */

import com.example.toolManagement.entities.User;
import com.example.toolManagement.model.CustomerUserDetails;
import com.example.toolManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository workerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = workerRepository.findByUsername(username);
        System.out.println(user.getUsername() + "   " + user.getPassword() + "  " + user.getRole());
        if (user == null)
            throw new UsernameNotFoundException("User Not Found");
        return new CustomerUserDetails(user);
    }
}