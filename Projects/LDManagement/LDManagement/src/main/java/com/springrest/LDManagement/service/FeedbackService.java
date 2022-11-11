package com.springrest.LDManagement.service;

import com.springrest.LDManagement.entities.Feedback;

import java.util.List;

/**
 * @author Zulfa Attar
 */
public interface FeedbackService {

    public Feedback giveFeedback(Feedback feedback);
    public List<Feedback> getFeedback();
}
