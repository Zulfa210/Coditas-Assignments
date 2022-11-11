package com.springrest.LDManagement.service;

import com.springrest.LDManagement.entities.Trainer;
import com.springrest.LDManagement.model.dto.TrainerDto;

import java.util.List;

/**
 * @author Zulfa Attar
 */
public interface TrainerService  {

    Trainer createTrainer(TrainerDto trainerDto);
    Trainer updateTrainer(Trainer trainer);
    List<Trainer> getTrainers();
    void deleteTrainer(int trainerId);
}
