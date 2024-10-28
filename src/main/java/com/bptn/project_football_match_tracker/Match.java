package com.bptn.project_football_match_tracker;

import java.util.Scanner;

//Creates a "Match" class that inherits from the "Game" class
public class Match extends Game {
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;
    private String referee;
    
    //Constructor to initialize date and venue using superclass constructor
    public Match(String date, String venue) {
        super(date, venue);
    }

    //Static method to create new Match instance using user-provided input.
    //This method uses a Scanner parameter to gather user input
    public static Match createMatch(Scanner scanner) {
        String date = InputValidator.userInputDate(scanner, "Enter match date (YYYY-MM-DD): ");
        String venue = InputValidator.userInputString(scanner, "Enter venue: ");
        Match match = new Match(date, venue);
        match.collectMatchDetails(scanner);
        return match;
    }

    //Method to collect match details using a Scanner parameter to gather user input
    public void collectMatchDetails(Scanner scanner) {
        this.homeTeam = InputValidator.userInputString(scanner, "Enter home team: ");
        this.awayTeam = InputValidator.userInputString(scanner, "Enter away team: ");
        this.homeScore = InputValidator.userInputInt(scanner, "Enter home score: ");
        this.awayScore = InputValidator.userInputInt(scanner, "Enter away score: ");
        this.referee = InputValidator.userInputString(scanner, "Enter referee name: ");
    }

    //Overrides the abstract method (getGameDetails()) to build and return a formatted string, with ANSI color codes for enhanced output
    @Override
    public String getGameDetails() {
        StringBuilder details = new StringBuilder();
        details.append("\033[38;5;214m📅 Date:\033[0m ").append(date).append("\n"); // Bright Orange
        details.append("\033[96m🏟 Venue:\033[0m ").append(venue).append("\n"); // Bright Cyan
        details.append("\033[92m⚽ Match:\033[0m ").append(homeTeam).append(" ").append(homeScore)
               .append(" - ").append(awayScore).append(" ").append(awayTeam).append("\n"); // Bright Green 
        details.append("\033[94m🧑‍⚖️ Referee:\033[0m ").append(referee).append("\n"); // Bright Blue

        return details.toString();
    }

    public int getTotalGoals() {
        return homeScore + awayScore;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    }

    

