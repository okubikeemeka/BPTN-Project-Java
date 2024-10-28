package com.bptn.project_football_match_tracker;

import java.util.Scanner;

public class InputValidator {

	//Creates method to validate string input to contain only letters and spaces.
	//Prompt is whatever text passed in when a method is called.
    public static String userInputString(Scanner scanner, String prompt) { 
        while (true) {
            System.out.print(prompt);
            try {
                String input = scanner.nextLine().trim();
                if (input.matches("[a-zA-Z ]+")) { //Uppercase(A-Z), lowercase(a-z) and spaces.
                    return input;
                } else {
                    System.out.println("\033[91mInvalid input. Please enter letters and spaces only.\033[0m"); //Bright Red
                }
            } catch (Exception e) {
                System.out.println("\033[91mInvalid input. Please try again.\033[0m"); //Bright Red
                scanner.nextLine(); // This clears the buffer if any unexpected exception occurs.
            }
        }
    }

    //Creates method to validate integer input that must be positive
    public static int userInputInt(Scanner scanner, String prompt) {  
        while (true) {
            System.out.print(prompt);  
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= 0) {
                    return value;
                } else {
                    System.out.println("\033[91mPlease enter a positive number.\033[0m"); //Bright Red
                }
            } catch (NumberFormatException e) {
                System.out.println("\033[91mInvalid input. Please enter a valid number.\033[0m"); //Bright Red
            }
        }
    }
    
    // Creates method to validate date input format as YYYY-MM-DD
    public static String userInputDate(Scanner scanner, String prompt) {   
        while (true) {
            System.out.print(prompt);  
            try {
                String input = scanner.nextLine().trim();
                if (input.matches("\\d{4}-\\d{2}-\\d{2}")) { //Matches date in YYYY-MM-DD pattern
                    return input;
                } else {
                    System.out.println("\033[91mInvalid date. Please use the format YYYY-MM-DD.\033[0m");
                }
            } catch (Exception e) {
                System.out.println("\033[91mInvalid input. Please try again.\033[0m");
                scanner.nextLine(); // This clears the buffer if any unexpected exception occurs.
            }
        }
    }
}
