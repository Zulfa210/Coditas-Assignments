package com.springrest.LDManagement.entities;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "student_details")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long studentId;

    @Column(nullable = false)
    private String studentName;

    @Column(nullable = false, unique = true)
    private String studentEmail;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_domain", nullable = false)
    private Domain studentDomain;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_trainer", nullable = false)
    private Trainer studentTrainer;

    @ColumnDefault(value = "false")
    private boolean isDeleted;

}
