package com.springrest.LDManagement.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "feedback_details")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long feedbackId;

    @Column(nullable = false)
    private Long studentId;

    @Column(nullable = false)
    private Long trainerId;

    @Column(nullable = false)
    private float feedbackRating;

    @Column(nullable = false)
    private String feedbackComment;

}
