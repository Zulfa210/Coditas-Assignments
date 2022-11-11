package com.springrest.LDManagement.repository;

import com.springrest.LDManagement.entities.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Zulfa Attar
 */

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
