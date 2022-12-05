package com.example.Battle_War.service;

import com.example.Battle_War.entities.Game;
import com.example.Battle_War.model.dto.GameDto;

/**
 * @author Zulfa Attar
 */
public interface GameService {

    public Game createGame(GameDto gameDto);

    public Game startGame(long gameId);
}
