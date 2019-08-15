package com.plugga.backend.entity;

import java.io.Serializable;
import java.util.Objects;

public class UserDeckId implements Serializable {
    private int user;
    private int deck;

    public int getUser() {
        return user;
    }

    public void setUser(final int user) {
        this.user = user;
    }

    public int getDeck() {
        return deck;
    }

    public void setDeck(final int deck) {
        this.deck = deck;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDeckId)) return false;
        final UserDeckId that = (UserDeckId) o;
        return getUser() == that.getUser() &&
                getDeck() == that.getDeck();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getDeck());
    }
}
