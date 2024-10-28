package com.bptn.project_football_match_tracker;

//Creates abstract class and declares its instance variables
public abstract class AbstractGame {
    protected String date;
    protected String venue;
    
    //Initializes variables (date and venue) using the constructor
    public AbstractGame(String date, String venue) {
        this.date = date;
        this.venue = venue;
    }

    // Abstract method for game details, which must be implemented by subclasses
    public abstract String getGameDetails();

    //Getter methods for date and venue
    public String getDate() {
        return date;
    }

    public String getVenue() {
        return venue;
    }
}
