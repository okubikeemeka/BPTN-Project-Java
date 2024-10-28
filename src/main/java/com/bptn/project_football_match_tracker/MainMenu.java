package com.bptn.project_football_match_tracker;

import java.util.Scanner;

public class MainMenu {
    private final ReportManager reportManager;
    private final Scanner scanner;
    
    //Uses constructor to initialize ReportManager and Scanner objects
    public MainMenu() {
        reportManager = new ReportManager();
        scanner = new Scanner(System.in);
    }

    //Displays the main menu to users
    public void display() {
        int choice;
        do {
        	
            // Using StringBuilder to construct the menu with ANSI color codes to style and enhance output
            StringBuilder menu = new StringBuilder();
            menu.append("\033[1;92m**** -->> Football Match Tracker <<-- ****\033[0m\n"); // Bright Green
            menu.append("\033[38;5;214m     1. ⚽ Record a new match\033[0m\n"); // Bright Orange
            menu.append("\033[96m     2. 📄 View past reports\033[0m\n"); // Bright Cyan
            menu.append("\033[95m     3. 📊 Generate statistics summary\033[0m\n"); // Bright Magenta
            menu.append("\033[91m     4. ❌ Delete a report\033[0m\n"); // Bright Red
            menu.append("\033[93m     5. 🚪 Exit\033[0m\n"); // Bright Yellow
            menu.append("\n\033[93m*********  Enter your choice: *********\033[0m "); // Bright Yellow

            // Prints the menu using the constructed StringBuilder.
            System.out.println(menu.toString());

            // Uses scanner to read user choice
            choice = InputValidator.userInputInt(scanner, "");

            switch (choice) {
                case 1 -> reportManager.recordNewMatch(scanner);
                case 2 -> reportManager.viewReports();
                case 3 -> reportManager.displayStatistics();
                case 4 -> reportManager.deleteReport(scanner);
                case 5 -> {
                    System.out.println("\033[91mExiting. Goodbye!\033[0m"); // Bright Red
                    scanner.close(); // Closes the scanner when exiting to avoid data leak.
                }
                default -> System.out.println("\033[93mInvalid choice. Please try again.\033[0m"); // Bright Yellow
            }
        } while (choice != 5); //Loops until user chooses to exit by selecting option 5
    }
    
    //Main method to start the application by displaying the main menu
    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        menu.display();
    }
}

