package com.example.oauthServer.repository;

import com.example.oauthServer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Zulfa Attar
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserEmail(String email);
}
