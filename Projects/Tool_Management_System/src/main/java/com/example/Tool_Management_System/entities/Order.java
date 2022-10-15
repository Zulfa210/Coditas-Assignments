package com.example.Tool_Management_System.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.util.List;

/**
 * @author Zulfa Attar
 */
@Entity
@Table(name = "order_details")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "order_id", updatable = false)
    private Long orderId;

    @Column(name = "customer_name")
    private String customerName;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "order_tools",
            joinColumns = {@JoinColumn(name = "orderId")},
            inverseJoinColumns = {@JoinColumn(name = "toolId")})
    private List<Tool> orderedTools;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "order_total_price")
    private float orderTotalPrice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "worker_id")
    @JsonIgnore
    private Worker worker;

    public Order(Long orderId, String customerName, List<Tool> orderedTools, String orderStatus, float orderTotalPrice, Worker worker) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderedTools = orderedTools;
        this.orderStatus = orderStatus;
        this.orderTotalPrice = orderTotalPrice;
        this.worker = worker;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Tool> getOrderedTools() {
        return orderedTools;
    }

    public void setOrderedTools(List<Tool> orderedTools) {
        this.orderedTools = orderedTools;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public float getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(float orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", orderedTools=" + orderedTools +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderTotalPrice=" + orderTotalPrice +
                ", worker=" + worker +
                '}';
    }
}