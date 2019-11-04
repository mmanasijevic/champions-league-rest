package net.jdevelopment.championsleaguerest.controller;

import net.jdevelopment.championsleaguerest.model.Team;
import net.jdevelopment.championsleaguerest.service.TeamService;
import net.jdevelopment.championsleaguerest.ui.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Team> getAllTeams () {
        return teamService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, path = API_PATH + "/games")
    public void addGames (@RequestBody List<Game> listOfGames) {
        for (Game game : listOfGames) {
            logger.info(game.toString());
        }

    }
}
