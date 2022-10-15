package com.example.Tool_Management_System.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAnyAttribute;
import java.util.List;

/**
 * @author Zulfa Attar
 */
@Entity
@Table(name = "tool_details")
public class Tool {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "tool_id", updatable = false)
    private Long toolId;

    @Column(name = "tool_name")
    private String toolName;

    @Column(name = "tool_size")
    private float toolSize;

    @Column(name = "tool_price")
    private float toolPrice;

    @Column(name = "tool_quantity")
    private float toolQuantity;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "orderedTools")
    @JsonIgnore
    private List<Order> orders;

    public Long getToolId() {
        return toolId;
    }

    public void setToolId(Long toolId) {
        this.toolId = toolId;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public float getToolSize() {
        return toolSize;
    }

    public void setToolSize(float toolSize) {
        this.toolSize = toolSize;
    }

    public float getToolPrice() {
        return toolPrice;
    }

    public void setToolPrice(float toolPrice) {
        this.toolPrice = toolPrice;
    }

    public float getToolQuantity() {
        return toolQuantity;
    }

    public void setToolQuantity(float toolQuantity) {
        this.toolQuantity = toolQuantity;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Tool() {
    }
}