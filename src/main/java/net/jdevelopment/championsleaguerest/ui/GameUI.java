package net.jdevelopment.championsleaguerest.ui;

public class GameUI {

    private String leagueTitle;
    private int matchday;
    private String group;
    private String homeTeam;
    private String awayTeam;
    private String kickoffAt;
    private String score;

    public GameUI() {
    }

    public String getLeagueTitle() {
        return leagueTitle;
    }

    public void setLeagueTitle(String leagueTitle) {
        this.leagueTitle = leagueTitle;
    }

    public int getMatchday() {
        return matchday;
    }

    public void setMatchday(int matchday) {
        this.matchday = matchday;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getKickoffAt() {
        return kickoffAt;
    }

    public void setKickoffAt(String kickoffAt) {
        this.kickoffAt = kickoffAt;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
