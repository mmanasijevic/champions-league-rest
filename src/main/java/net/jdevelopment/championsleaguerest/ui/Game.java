package net.jdevelopment.championsleaguerest.ui;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Game {

    private String leagueTitle;
    private int matchday;
    private String group;
    private String homeTeam;
    private String awayTeam;
    private String kickoffAt;
    private String score;

}
