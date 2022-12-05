package com.springrest.LDManagement.service;

import com.springrest.LDManagement.entities.Feedback;
import com.springrest.LDManagement.entities.Student;
import com.springrest.LDManagement.entities.Trainer;
import com.springrest.LDManagement.repository.FeedbackRepository;
import com.springrest.LDManagement.repository.StudentRepository;
import com.springrest.LDManagement.repository.TrainerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

/**
 * @author Zulfa Attar
 */
//@ExtendWith(MockitoExtension.class)
class FeedbackServiceImplementationTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private FeedbackRepository feedbackRepository;

    @Mock
    private TrainerRepository trainerRepository;

    @InjectMocks
    private FeedbackServiceImplementation feedbackServiceImplementation;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
     //   feedbackServiceImplementation = new FeedbackServiceImplementation(feedbackRepository, trainerRepository, studentRepository);
    }

    @Test
    void getAllFeedback() {
    }

    @Test
    void giveFeedback() {

        Feedback feedback = new Feedback();
        feedback.setStudentId(1L);
        feedback.setTrainerId(1L);
        feedback.setFeedbackRating(5);
        feedback.setFeedbackComment("Excellent");

        when(studentRepository.findById(anyLong())).thenReturn(
                Optional.of(new Student(1L, "Zulfa", "zulfa@gmail.com",
                        new Trainer(1L, "Aarti", "aarti@gmail.com", 20000f, false),
                        false)));

        feedbackServiceImplementation.giveFeedback(feedback);

        ArgumentCaptor<Feedback> feedbackArgumentCaptor = ArgumentCaptor.forClass(Feedback.class);

        Mockito.verify(feedbackRepository).save(feedbackArgumentCaptor.capture());
        Feedback feedback1 = feedbackArgumentCaptor.getValue();

        assertThat(feedback1).isEqualTo(feedback);
    }

    @Test
    void getTrainerFeedback() {
    }

    @Test
    void getTrainerFeedbackAverage() {
    }
}