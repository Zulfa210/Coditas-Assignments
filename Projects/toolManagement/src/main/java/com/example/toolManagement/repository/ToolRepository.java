package com.example.toolManagement.repository;

/**
 * @author Zulfa Attar
 */

import com.example.toolManagement.entities.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {
}