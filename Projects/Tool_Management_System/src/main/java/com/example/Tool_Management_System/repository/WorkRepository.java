package com.example.Tool_Management_System.repository;

import com.example.Tool_Management_System.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Zulfa Attar
 */
@Repository
public interface WorkRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}