package com.example.toolManagement.model.dto;

import java.util.List;

public class OrderDto {
    private Long orderId;
    private Long workerId;
    private List<ToolDto> requiredTools;
    private String customerName;
    private String orderStatus;

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public List<ToolDto> getRequiredTools() {
        return requiredTools;
    }

    public void setRequiredTools(List<ToolDto> requiredTools) {
        this.requiredTools = requiredTools;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
