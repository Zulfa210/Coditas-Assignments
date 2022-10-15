package com.example.Tool_Management_System.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * @author Zulfa Attar
 */

@Entity
@Table(name = "worker_details")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "worker_id", updatable = false)
    private Long workerId;

    @Column(name = "worker_name")
    private String workerName;

    @Column(name = "worker_username")
    private String workerUsername;

    @Column(name = "worker_password")
    private String workerPassword;

    @Column(name = "worker_salary")
    private float workerSalary;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "worker")
    private Set<Order> worker_orders;

    public Worker(Long workerId, String workerName, String workerUsername, String workerPassword, float workerSalary, Set<Order> worker_orders, String role) {
        this.workerId = workerId;
        this.workerName = workerName;
        this.workerUsername = workerUsername;
        this.workerPassword = workerPassword;
        this.workerSalary = workerSalary;
        this.worker_orders = worker_orders;
        this.role = role;
    }

    @Column(name = "worker_role")
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getWorkerUsername() {
        return workerUsername;
    }

    public void setWorkerUsername(String workerUsername) {
        this.workerUsername = workerUsername;
    }

    public String getWorkerPassword() {
        return workerPassword;
    }

    public void setWorkerPassword(String workerPassword) {
        this.workerPassword = workerPassword;
    }

    public float getWorkerSalary() {
        return workerSalary;
    }

    public void setWorkerSalary(float workerSalary) {
        this.workerSalary = workerSalary;
    }

    public Set<Order> getWorker_orders() {
        return worker_orders;
    }

    public void setWorker_orders(Set<Order> worker_orders) {
        this.worker_orders = worker_orders;
    }

    public Worker() {
    }
}