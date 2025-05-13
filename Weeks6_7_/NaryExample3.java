package Weeks6_7_;

import java.util.ArrayList;
import java.util.List;

// Entity classes
class Team {
    private String name;
    private List<SeasonPerformance> seasonPerformances;

    public Team(String name) {
        this.name = name;
        this.seasonPerformances = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addSeasonPerformance(SeasonPerformance performance) {
        this.seasonPerformances.add(performance);
    }

    public List<SeasonPerformance> getSeasonPerformances() {
        return seasonPerformances;
    }
}

class Year {
    private int year;  // Year artık yıl değeri tutuyor
    private List<SeasonPerformance> seasonPerformances;

    public Year(int year) {
        this.year = year;
        this.seasonPerformances = new ArrayList<>();
    }

    public int getYear() {
        return year;
    }

    public void addSeasonPerformance(SeasonPerformance performance) {
        this.seasonPerformances.add(performance);
    }

    public List<SeasonPerformance> getSeasonPerformances() {
        return seasonPerformances;
    }
}

class Player {
    private String name;
    private boolean isGoalkeeper;
    private List<SeasonPerformance> seasonPerformances;

    public Player(String name, boolean isGoalkeeper) {
        this.name = name;
        this.isGoalkeeper = isGoalkeeper;
        this.seasonPerformances = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean isGoalkeeper() {
        return isGoalkeeper;
    }

    public void addSeasonPerformance(SeasonPerformance performance) {
        this.seasonPerformances.add(performance);
    }

    public List<SeasonPerformance> getSeasonPerformances() {
        return seasonPerformances;
    }
}

class Record {
    private int goalsFor;
    private int goalsAgainst;
    private int wins;
    private int losses;
    private int ties;

    public Record(int goalsFor, int goalsAgainst, int wins, int losses, int ties) {
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
    }

    // Getters
    public int getGoalsFor() {
        return goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getTies() {
        return ties;
    }
}

// N-ary relationship class that respects the specific roles
class SeasonPerformance {
    private Team team;              // "team" role
    private Year seasonYear;        // "season" role
    private List<Player> players;   // Regular players
    private Player goalkeeper;      // "goalkeeper" role
    private Record record;          // Performance record

    public SeasonPerformance(Team team, Year seasonYear, Record record) {
        this.team = team;
        this.seasonYear = seasonYear;
        this.players = new ArrayList<>();
        this.record = record;
        
        // Establish bidirectional relationships
        team.addSeasonPerformance(this);
        seasonYear.addSeasonPerformance(this);
    }

    // Add a regular player
    public void addPlayer(Player player) {
        if (!player.isGoalkeeper()) {
            this.players.add(player);
            player.addSeasonPerformance(this);
        }
    }
    
    // Set the goalkeeper (special role)
    public void setGoalkeeper(Player goalkeeper) {
        if (goalkeeper.isGoalkeeper()) {
            this.goalkeeper = goalkeeper;
            goalkeeper.addSeasonPerformance(this);
        } else {
            throw new IllegalArgumentException("Player must be a goalkeeper");
        }
    }

    // Getters that reflect the roles
    public Team getTeam() {
        return team;
    }

    public Year getSeason() {  // Named getSeason to reflect the role
        return seasonYear;
    }

    public List<Player> getPlayers() {
        return players;
    }
    
    public Player getGoalkeeper() {
        return goalkeeper;
    }

    public Record getRecord() {
        return record;
    }
}

// Usage example
public class NaryExample3 {
    public static void main(String[] args) {
        // Create entities
        Team barcelona = new Team("FC Barcelona");
        Year year2023 = new Year(2023);
        Player messi = new Player("Messi", false);
        Player terStegen = new Player("Ter Stegen", true);
        
        // Create record
        Record barcelonaRecord = new Record(102, 35, 25, 6, 7);
        
        // Create the relationship
        SeasonPerformance performance = new SeasonPerformance(barcelona, year2023, barcelonaRecord);
        
        // Add players to the relationship
        performance.addPlayer(messi);
        performance.setGoalkeeper(terStegen);
        
        // Now we can access data through the relationship
        System.out.println("Team: " + performance.getTeam().getName());
        System.out.println("Season: " + performance.getSeason().getYear());
        System.out.println("Goals scored: " + performance.getRecord().getGoalsFor());
        System.out.println("Regular players:");
        for (Player player : performance.getPlayers()) {
            System.out.println("- " + player.getName());
        }
        System.out.println("Goalkeeper: " + performance.getGoalkeeper().getName());
    }
}