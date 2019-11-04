package net.jdevelopment.championsleaguerest.bootstrap;

import net.jdevelopment.championsleaguerest.model.Team;
import net.jdevelopment.championsleaguerest.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DataLoader implements CommandLineRunner {

    private TeamService teamService;

    private Logger logger = LoggerFactory.getLogger(DataLoader.class);

    @Autowired
    public DataLoader(TeamService teamService) {
        this.teamService = teamService;
    }

    @Override
    public void run(String... args) throws Exception {

        final Team arsenal = new Team("Arsenal");
        teamService.save(arsenal);
        logger.info("Arsenal added ...");

        final Team psg = new Team("PSG");
        teamService.save(psg);
        logger.info("PSG added ...");

        final Team ludogorets = new Team("Ludogorets");
        teamService.save(ludogorets);
        logger.info("Ludogorets added ...");

        final Team basel = new Team("Basel");
        teamService.save(basel);
        logger.info("Basel added ...");
    }

}
