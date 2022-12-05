package com.example.Battle_War.repository;

import com.example.Battle_War.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Zulfa Attar
 */
public interface GameRepository extends JpaRepository<Game, Long> {
}
