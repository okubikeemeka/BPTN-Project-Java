package com.bptn.project_football_match_tracker;
//Imports collections, file handling and utility classes for input and output operations
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ReportManager {
	//Declares and initializes matchReports as a new ArrayList
    private final List<Match> matchReports = new ArrayList<>();

    // Method to strip ANSI escape codes
    public static String stripAnsiCodes(String input) {
        return input.replaceAll("\u001B\\[[;\\d]*m", "");
    }
    
    //Method to record a new match
    public void recordNewMatch(Scanner scanner) {
        Match match = Match.createMatch(scanner);
        saveReport(match);
        System.out.println("\033[96mMatch recorded and saved successfully!\033[0m"); // Bright Cyan
    }

    //Method to save a given match report to a file
    public void saveReport(Match match) {
        matchReports.add(match);
        String fileName = "MatchReport_" + match.getDate().replace("-", "") + ".txt";
        
        // Get the game details with ANSI codes stripped
        String cleanDetails = stripAnsiCodes(match.getGameDetails());

        //Write match details to a file and handle any potential IO Exceptions
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(cleanDetails);
            System.out.println("\033[93mMatch recorded and saved as " + fileName + "\033[0m"); //Bright Yellow
        } catch (IOException e) {
            System.out.println("Error saving report: " + e.getMessage());
        }
    }

    //Method to display all recorded match reports
    public void viewReports() {
        if (matchReports.isEmpty()) { //Checks if none is available
            System.out.println("\033[91m🚫 No reports available.\033[0m"); //Bright Red
        } else {
            for (Match match : matchReports) {
                System.out.println(match.getGameDetails());
            }
        }
    }

    //Method to display statistics
    public void displayStatistics() {
        if (matchReports.isEmpty()) {
            System.out.println("\033[91m🚫 No match data available.\033[0m"); // Bright Red
            return;
        }

        int totalMatches = matchReports.size();
        int totalGoals = matchReports.stream() //Streams through each match in list
                                     .mapToInt(Match::getTotalGoals) //Map each match to its total goals
                                     .sum();
        double averageGoals = totalMatches > 0 ? (double) totalGoals / totalMatches : 0.0;

        System.out.println("\033[94m📊 Match Statistics:\033[0m"); //Bright Blue
        System.out.println("\033[96m⚽ Total Matches: \033[0m" + totalMatches); //Bright Cyan
        System.out.println("\033[92m🎯 Total Goals: \033[0m" + totalGoals); //Bright Green
        System.out.println("\033[93m📈 Average Goals per Match: \033[0m" + String.format("%.2f", averageGoals)); //Bright Yellow
    }

    //Method to delete a specific match report based on provided date
    public void deleteReport(Scanner scanner) {
        System.out.print("Enter the date of the report to delete (YYYY-MM-DD): ");
        String date = scanner.nextLine().trim();
        deleteReportByDate(date); //Calls helper method to delete report
    }

    // Helper method for deleting match report by date
    private void deleteReportByDate(String date) {
        String fileName = "MatchReport_" + date.replace("-", "") + ".txt";
        Path filePath = Paths.get(fileName);

        //Attempt to delete the file, handling potential IO Exceptions
        try {
            Files.delete(filePath);
            System.out.println("\033[92mReport " + fileName + " has been deleted successfully.\033[0m"); // Bright Green
        } catch (IOException e) {
            System.out.println("\033[91mFailed to delete the report: " + fileName + ". Error: " + e.getMessage() + "\033[0m"); // Bright Red
        }
    }
}

