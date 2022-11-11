package com.springrest.LDManagement.repository;

import com.springrest.LDManagement.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Zulfa Attar
 */
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
