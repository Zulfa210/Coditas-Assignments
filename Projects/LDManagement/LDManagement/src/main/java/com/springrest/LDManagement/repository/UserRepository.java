package com.springrest.LDManagement.repository;

import com.springrest.LDManagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Zulfa Attar
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long > {
    User findByEmail(String email);
}
