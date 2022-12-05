package com.example.Battle_War.repository;

import com.example.Battle_War.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Zulfa Attar
 */
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
