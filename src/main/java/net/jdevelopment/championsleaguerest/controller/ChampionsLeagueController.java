package net.jdevelopment.championsleaguerest.controller;

import net.jdevelopment.championsleaguerest.model.Team;
import net.jdevelopment.championsleaguerest.service.TeamService;
import net.jdevelopment.championsleaguerest.ui.GameUI;
import net.jdevelopment.championsleaguerest.ui.TeamUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChampionsLeagueController {

    private static final String API_PATH = "/api/v1";

    private TeamService teamService;

    private static final Logger logger = LoggerFactory.getLogger(ChampionsLeagueController.class);

    @Autowired
    public ChampionsLeagueController(TeamService teamService) {
        this.teamService = teamService;
    }

    @RequestMapping(method = RequestMethod.GET, path = API_PATH + "/games")
    public List<TeamUI> getAllTeams () {
        List<TeamUI> allTeamsUI = new ArrayList<>();

        List<Team> allAndSort = teamService.findAllAndSort();
        for (int i = 0; i < allAndSort.size(); i ++) {
            Team team = allAndSort.get(i);
            TeamUI teamUI = team.toTeamUI();
            teamUI.setRank(i + 1);

            allTeamsUI.add(teamUI);
        }

        return allTeamsUI;
    }

    @RequestMapping(method = RequestMethod.POST, path = API_PATH + "/games")
    public List<TeamUI> addGames (@RequestBody List<GameUI> listOfGameUIS) {
        for (GameUI gameUI : listOfGameUIS) {

            Team homeTeam = teamService.findTeamByName(gameUI.getHomeTeam());
            Team awayTeam = teamService.findTeamByName(gameUI.getAwayTeam());

            String score = gameUI.getScore();
            String[] scoreArray = score.split(":");

            int homeGoals = Integer.parseInt(scoreArray[0]);
            int awayGoals = Integer.parseInt(scoreArray[1]);

            // we have 3 possibility >, <, =
            if (homeGoals > awayGoals)
            {
                homeTeam.setWin(homeTeam.getWin() + 1);
                homeTeam.setPoints(homeTeam.getPoints() + 3);

                awayTeam.setLose(awayTeam.getLose() + 1);

            }
            else if (homeGoals == awayGoals)
            {
                homeTeam.setDraw(homeTeam.getDraw() + 1);
                awayTeam.setDraw(awayTeam.getDraw() + 1);

                homeTeam.setPoints(homeTeam.getPoints() + 1);
                awayTeam.setPoints(awayTeam.getPoints() + 1);
            }
            else
            {
                homeTeam.setLose(homeTeam.getLose() + 1);

                awayTeam.setWin(awayTeam.getWin() + 1);
                awayTeam.setPoints(awayTeam.getPoints() + 3);
            }

            homeTeam.setPlayedGames(homeTeam.getPlayedGames() + 1);
            awayTeam.setPlayedGames(awayTeam.getPlayedGames() + 1);

            homeTeam.setGoals(homeTeam.getGoals() + homeGoals);
            homeTeam.setGoalsAgainst(homeTeam.getGoalsAgainst() + awayGoals);

            awayTeam.setGoals(awayTeam.getGoals() + awayGoals);
            awayTeam.setGoalsAgainst(homeTeam.getGoalsAgainst() + homeGoals);

            homeTeam.setGoalDifference(homeTeam.getGoals() - homeTeam.getGoalsAgainst());
            awayTeam.setGoalDifference(awayTeam.getGoals() - awayTeam.getGoalsAgainst());

            teamService.save(homeTeam);
            teamService.save(awayTeam);
        }

        // just return all teams
        return getAllTeams();
    }
}
