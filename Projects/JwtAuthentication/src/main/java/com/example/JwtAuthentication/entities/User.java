package com.example.JwtAuthentication.entities;

import lombok.Data;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.*;

/**
 * @author Zulfa Attar
 */
@Data
@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "unique_email", columnNames = "userEmail"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String userName;
    private String userEmail;
    private String password;
    private String userCity;
    private float userSalary;
    private String userRole;
}
