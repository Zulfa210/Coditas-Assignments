package com.example.Battle_War.entities;

import javax.persistence.*;
import java.util.List;

/**
 * @author Zulfa Attar
 */
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long playerId;

    private String playerName;

    private boolean isPlaying;

    @OneToMany
    private List<PlayedGame> playedGames;

}
