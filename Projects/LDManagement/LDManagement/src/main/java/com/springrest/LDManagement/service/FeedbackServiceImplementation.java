package com.springrest.LDManagement.service;

import com.springrest.LDManagement.entities.Feedback;
import com.springrest.LDManagement.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Zulfa Attar
 */
public class FeedbackServiceImplementation implements FeedbackService{

    @Autowired
    FeedbackRepository feedbackRepository;
    @Override
    public Feedback giveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public List<Feedback> getFeedback() {
        return feedbackRepository.findAll();
    }
}
