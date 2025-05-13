package com.flashcard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FlashCardApp {
    private static List<FlashCard> flashCards = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Load flashcards from file
        loadFlashCardsFromFile("data.txt");

        System.out.println("Welcome to the FlashCard System!");
        System.out.println("Options:");
        System.out.println("--help for help");
        System.out.println("--order <order> for the order type (random, worst-first, recent-mistakes-first)");
        System.out.println("--exit to exit");

        // Parse arguments for order option
        String orderType = "random"; // Default order
        for (String arg : args) {
            if (arg.startsWith("--order")) {
                orderType = arg.split("=")[1];
            }
        }

        // If user requested help, print the help message
        if (args.length > 0 && args[0].equals("--help")) {
            printHelp();
            return;  // Exit after displaying help
        }

        // Organize flashcards based on order
        List<FlashCard> organizedCards = organizeCards(orderType);

        // Check if user wants to exit before starting the game
        if (args.length > 0 && args[0].equals("--exit")) {
            System.out.println("Exiting the FlashCard app. Goodbye!");
            return;  // Exit the app
        }

        // Play game
        playGame(organizedCards);
    }

    private static void loadFlashCardsFromFile(String fileName) {
        try {
            Scanner fileScanner = new Scanner(new File(fileName));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\t");
                String question = parts[0];  // Question is the second column
                String answer = parts[1];    // Answer is the third column
                flashCards.add(new FlashCard(question, answer));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    private static List<FlashCard> organizeCards(String orderType) {
        List<FlashCard> organizedCards = new ArrayList<>(flashCards);

        if ("random".equals(orderType)) {
            Random rand = new Random();
            for (int i = 0; i < organizedCards.size(); i++) {
                int j = rand.nextInt(organizedCards.size());
                FlashCard temp = organizedCards.get(i);
                organizedCards.set(i, organizedCards.get(j));
                organizedCards.set(j, temp);
            }
        } else if ("worst-first".equals(orderType)) {
            // Implement worst-first logic here (e.g., by tracking mistakes)
        } else if ("recent-mistakes-first".equals(orderType)) {
            // Implement recent-mistakes-first logic here (if applicable)
        }

        return organizedCards;
    }

    private static void playGame(List<FlashCard> cards) {
        System.out.println("Starting the quiz!");

        int correctAnswers = 0;

        for (FlashCard card : cards) {
            System.out.println("garahiig husvel done\n"+"Question: " + card.getQuestion());
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();
            
             if (userAnswer.equalsIgnoreCase("done")) {
            return; // Exit the game if user types "done"
        }
            if (userAnswer.equalsIgnoreCase(card.getAnswer())) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("Wrong! The correct answer is: " + card.getAnswer());
            }
        }

        System.out.println("\nQuiz finished!");
        System.out.println("You got " + correctAnswers + " out of " + cards.size() + " correct.");
    }

    // Method to print help information
    private static void printHelp() {
        System.out.println("Help - Flashcard System:");
        System.out.println("--help : Show help information.");
        System.out.println("--order <order> : Set the order of cards (random, worst-first, recent-mistakes-first).");
        System.out.println("--exit : Exit the application.");
        System.out.println("Example usage: mvn exec:java \"-Dexec.args=--order=random\"");
    }
}
