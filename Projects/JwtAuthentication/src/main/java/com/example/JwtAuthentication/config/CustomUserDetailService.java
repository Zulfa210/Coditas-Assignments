package com.example.JwtAuthentication.config;


import com.example.JwtAuthentication.entities.User;
import com.example.JwtAuthentication.model.CustomerUserDetails;
import com.example.JwtAuthentication.repository.UserRepository;
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
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User user = workerRepository.findByUserEmail(userEmail);
        //System.out.println(user.getUsername() + "   " + user.getPassword() + "  " + user.getRole());
        if (user == null)
            throw new UsernameNotFoundException("User Not Found");
        return new CustomerUserDetails(user);
    }
}