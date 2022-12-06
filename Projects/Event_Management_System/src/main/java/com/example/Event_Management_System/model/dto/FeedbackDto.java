package com.example.Event_Management_System.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zulfa Attar
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDto {

    private String feedbackComment;
    private float feedBackRating;
    private Long eventId;
    private Long customerId;


}
