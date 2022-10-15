package com.example.Tool_Management_System.repository;

import com.example.Tool_Management_System.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Zulfa Attar
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
