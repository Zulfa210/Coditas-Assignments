package com.example.toolManagement.repository;

/**
 * @author Zulfa Attar
 */

import com.example.toolManagement.entities.Worker;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
    @Query("SELECT w.workerId FROM Worker w WHERE w.workerUsername = ?1")
    Long findIdByUsername(String username);


}