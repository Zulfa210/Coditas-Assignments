package com.example.JwtAuthentication.repository;

import com.example.JwtAuthentication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Zulfa Attar
 */
public interface UserRepository extends JpaRepository<User, Long> {


    User findByUserEmail(String userEmail);

}
