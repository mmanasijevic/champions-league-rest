package net.jdevelopment.championsleaguerest.controller;

import net.jdevelopment.championsleaguerest.model.Team;
import net.jdevelopment.championsleaguerest.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChampionsLeagueController {

    private static final String API_PATH = "/api/v1";

    private TeamService teamService;

    @Autowired
    public ChampionsLeagueController(TeamService teamService) {
        this.teamService = teamService;
    }

    @RequestMapping(method = RequestMethod.GET, path = API_PATH + "/games")
    public List<Team> getAllTeams () {
        return teamService.findAll();
    }
}
