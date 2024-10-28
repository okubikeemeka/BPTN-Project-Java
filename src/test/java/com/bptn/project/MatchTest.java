package com.bptn.project;

import org.junit.jupiter.api.Test;
import com.bptn.project_football_match_tracker.Match;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.*;

public class MatchTest {
	
     //Test method to validate the creation of instance of Match class with expected user inputs
    @Test
    void testCreateMatch() {
    	
    	//Uses ByteArrayInputStream to test user input simulation
        String input = "2024-10-26\nStadium\nHomeTeam\nAwayTeam\n2\n3\nRefereeName\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        
        //Calls the method with simulated input
        Match match = Match.createMatch(scanner);

        //Asserts that Match object is created with expect user inputs
        assertEquals("2024-10-26", match.getDate(),"Date should match the input.");
        assertEquals("Stadium", match.getVenue(), "Venue should match the input.");
        assertEquals("HomeTeam", match.getHomeTeam(),"Home team should match the input.");
        assertEquals("AwayTeam", match.getAwayTeam(),"Away team should match the input.");
        assertEquals(5, match.getTotalGoals(),"Total goals should be the sum of home and away scores.");
    }
}
