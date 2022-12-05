package com.example.SpringSecurity.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Zulfa Attar
 */
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String userFirstName;
    private String userLastName;

    @Column(length = 60)
    private String userPassword;
    private String userEmail;
    private String userRole;
    private boolean enabled= false;

}
