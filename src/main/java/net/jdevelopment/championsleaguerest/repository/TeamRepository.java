package net.jdevelopment.championsleaguerest.repository;

import net.jdevelopment.championsleaguerest.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
