package com.flashcard;

import java.util.Scanner;

public class FlashCardApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the FlashCard System!");
        System.out.print("Enter question: ");
        String question = scanner.nextLine();

        System.out.print("Enter answer: ");
        String answer = scanner.nextLine();

        FlashCard card = new FlashCard(question, answer);
        System.out.println("\nCreated FlashCard:");
        System.out.println(card);

        scanner.close();
    }
}

