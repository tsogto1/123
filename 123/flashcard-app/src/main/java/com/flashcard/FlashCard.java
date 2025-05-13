package com.flashcard;

public class FlashCard {
    private String question;
    private String answer;

    // Constructor
    public FlashCard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    // Getter for question
    public String getQuestion() {
        return question;
    }

    // Setter for question
    public void setQuestion(String question) {
        this.question = question;
    }

    // Getter for answer
    public String getAnswer() {
        return answer;
    }

    // Setter for answer
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
