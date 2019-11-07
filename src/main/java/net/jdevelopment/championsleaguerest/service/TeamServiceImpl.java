package net.jdevelopment.championsleaguerest.service;

import net.jdevelopment.championsleaguerest.model.Team;
import net.jdevelopment.championsleaguerest.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team findTeamByName(String teamName) {
        return teamRepository.findTeamByName(teamName);
    }

    @Override
    public List<Team> findAllAndSort() {
        return teamRepository.findAllAndSort();
    }

    @Override
    public Team save(Team team) {
        return teamRepository.save(team);
    }
}
