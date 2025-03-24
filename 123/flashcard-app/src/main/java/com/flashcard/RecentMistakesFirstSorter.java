package com.flashcard;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class RecentMistakesFirstSorter implements CardOrganizer {
    private List<FlashCard> mistakenCards = new ArrayList<>();

    public void addMistake(FlashCard card) {
        mistakenCards.add(card);
    }

    @Override
    public List<FlashCard> organize(List<FlashCard> cards) {
        List<FlashCard> sortedCards = new ArrayList<>(cards);
        sortedCards.removeAll(mistakenCards);
        sortedCards.addAll(0, mistakenCards);  // Mistakes first
        return sortedCards;
    }
}

