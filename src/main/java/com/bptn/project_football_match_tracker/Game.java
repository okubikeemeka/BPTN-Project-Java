package com.bptn.project_football_match_tracker;

//Creates a "Game" class that inherits from the abstract class
public class Game extends AbstractGame {

    public Game(String date, String venue) {
        super(date, venue); // Calls the constructor of the abstract class.
    }

    //Overrides the abstract method (getGameDetails()) to return a formatted string with game details
    @Override
    public String getGameDetails() {
        return String.format("Game on %s at %s", date, venue);
    }
}
