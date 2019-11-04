package net.jdevelopment.championsleaguerest.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String team;
    private int playedGames;
    private int points;
    private int goals;
    private int goalsAgainst;
    private int goalDifference;
    private int win;
    private int lose;
    private int draw;

    public Team(String team) {
        this.team = team;
        this.playedGames = 0;
        this.points = 0;
        this.goals = 0;
        this.goalsAgainst = 0;
        this.goalDifference = 0;
        this.win = 0;
        this.lose = 0;
        this.draw = 0;
    }
}
