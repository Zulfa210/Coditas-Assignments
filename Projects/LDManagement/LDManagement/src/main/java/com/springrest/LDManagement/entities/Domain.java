package com.springrest.LDManagement.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "domain_details")
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long domainId;

    @Column(nullable = false)
    private String domainName;

    @OneToMany(mappedBy = "studentDomain", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "domain")
    private Trainer trainer;


}
