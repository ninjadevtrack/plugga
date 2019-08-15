package com.plugga.backend.entity;

import java.io.Serializable;
import java.util.Objects;

public class DeckCardId implements Serializable {
    private int deck;
    private int card;

    public int getDeck() {
        return deck;
    }

    public void setDeck(final int deck) {
        this.deck = deck;
    }

    public int getCard() {
        return card;
    }

    public void setCard(final int card) {
        this.card = card;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof DeckCardId)) return false;
        final DeckCardId that = (DeckCardId) o;
        return getDeck() == that.getDeck() &&
                getCard() == that.getCard();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDeck(), getCard());
    }
}
