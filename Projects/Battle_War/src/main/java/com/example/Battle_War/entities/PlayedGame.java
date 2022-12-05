package com.example.Battle_War.entities;

import lombok.Data;
import javax.persistence.*;

/**
 * @author Zulfa Attar
 */

@Entity
@Data
public class PlayedGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long playedGameId;

    @ManyToOne
    private Game game;

    @ManyToOne
    private Player player1;

    @ManyToOne
    private Player player2;

    private int player1XCoordinate;

    private int player1YCoordinate;
    private int player2XCoordinate;
    private int player2YCoordinate;

    private boolean gameStatus;

}
