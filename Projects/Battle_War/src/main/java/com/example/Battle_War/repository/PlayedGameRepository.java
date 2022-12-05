package com.example.Battle_War.repository;

import com.example.Battle_War.entities.PlayedGame;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Zulfa Attar
 */
public interface PlayedGameRepository extends JpaRepository<PlayedGame, Long> {
}
