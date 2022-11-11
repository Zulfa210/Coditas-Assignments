package com.example.Feedback_System.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Zulfa Attar
 */

@Entity
@Table(name = "employment_type")
public class EmploymentType {
    @Id
    private int e;
}
