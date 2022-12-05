package com.example.Battle_War.entities;

import javax.persistence.*;

/**
 * @author Zulfa Attar
 */
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gameId;

    private String gameName;

}
