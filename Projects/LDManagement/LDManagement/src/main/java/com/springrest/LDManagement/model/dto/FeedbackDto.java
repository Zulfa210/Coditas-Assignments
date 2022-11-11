package com.springrest.LDManagement.model.dto;

import lombok.Data;

import javax.persistence.Column;

/**
 * @author Zulfa Attar
 */
@Data
public class FeedbackDto {

    private Long feedbackId;
    private Long studentId;
    private Long trainerId;
    private float feedbackRating;
    private String feedbackComment;
}
