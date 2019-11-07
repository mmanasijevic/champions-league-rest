package net.jdevelopment.championsleaguerest.repository;

import net.jdevelopment.championsleaguerest.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query("SELECT t FROM Team t WHERE t.team = ?1")
    Team findTeamByName(String teamName);

    @Query ("SELECT t FROM Team t ORDER BY t.points DESC, t.goals DESC, t.goalDifference DESC ")
    List<Team> findAllAndSort ();
}
