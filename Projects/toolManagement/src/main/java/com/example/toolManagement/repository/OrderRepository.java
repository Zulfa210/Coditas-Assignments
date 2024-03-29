package com.example.toolManagement.repository;

/**
 * @author Zulfa Attar
 */

import com.example.toolManagement.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}