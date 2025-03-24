package com.flashcard;

import java.util.Scanner;

public class FlashCardApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the FlashCard System!");
        
        // Ask for question
        System.out.print("Enter question: ");
        String question = scanner.nextLine();
        
        // Ask for answer
        System.out.print("Enter answer: ");
        String answer = scanner.nextLine();
        
        // Display the entered flashcard
        System.out.println("\nFlashcard Created!");
        System.out.println("Question: " + question);
        System.out.println("Answer: " + answer);

        scanner.close();
    }
}
