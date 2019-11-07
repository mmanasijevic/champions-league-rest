package net.jdevelopment.championsleaguerest.service;

import net.jdevelopment.championsleaguerest.model.Team;

import java.util.List;

public interface TeamService {

    List<Team> findAll();

    Team findTeamByName(String teamName);

    List<Team> findAllAndSort ();

    Team save(Team team);
}
