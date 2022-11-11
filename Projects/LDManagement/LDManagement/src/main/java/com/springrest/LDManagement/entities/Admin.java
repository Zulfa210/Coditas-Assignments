package com.springrest.LDManagement.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "admin_details")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long adminId;

    @Column(nullable = false)
    private String adminName;

    @Column(nullable = false, unique = true)
    private String adminEmail;
}
