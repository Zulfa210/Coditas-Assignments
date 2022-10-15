package com.example.Tool_Management_System.entities;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author Zulfa Attar
 */
public class ToolQuantity {

    @Id
    private int quantityId;

    @OneToOne
    private Order order;

    @OneToOne
    private Tool tool;

    private int toolQuantity;

}
