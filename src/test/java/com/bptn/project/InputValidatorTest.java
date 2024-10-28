package com.bptn.project;

import org.junit.jupiter.api.Test;
import com.bptn.project_football_match_tracker.InputValidator;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.*;

public class InputValidatorTest {
	
     //Test method for integer input validation in "userInputInt" method
    @Test
    void testUserInputInt() {
    	//Simulates and checks various user inputs (invalid, negative, valid positive integer)
        String input = "invalid\n-10\n5\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        
        //Asserts that only valid integer is returned
        int result = InputValidator.userInputInt(scanner, "Enter a number: ");
        assertEquals(5, result, "Method should return the first valid positive integer.");
    }
}
