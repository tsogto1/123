package com.flashcard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlashCardApp {
    private static List<FlashCard> flashCards = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the FlashCard System!");
        
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a new flashcard");
            System.out.println("2. View all flashcards");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            if (choice == 1) {
                addFlashCard(scanner);
            } else if (choice == 2) {
                viewFlashCards();
            } else if (choice == 3) {
                System.out.println("Exiting... Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            }
        }

        scanner.close();
    }

    private static void addFlashCard(Scanner scanner) {
        System.out.print("Enter question: ");
        String question = scanner.nextLine();

        System.out.print("Enter answer: ");
        String answer = scanner.nextLine();

        flashCards.add(new FlashCard(question, answer));
        System.out.println("Flashcard added successfully!");
    }

    private static void viewFlashCards() {
        if (flashCards.isEmpty()) {
            System.out.println("No flashcards available.");
        } else {
            System.out.println("\nFlashcards:");
            for (int i = 0; i < flashCards.size(); i++) {
                System.out.println((i + 1) + ". Question: " + flashCards.get(i).getQuestion());
                System.out.println("   Answer: " + flashCards.get(i).getAnswer());
            }
        }
    }
}
