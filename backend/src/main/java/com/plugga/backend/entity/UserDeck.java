package com.plugga.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "user_deck")
@IdClass(UserDeckId.class)
public class UserDeck {

    @Id
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @Id
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "deck_id", referencedColumnName = "deck_id")
    private Deck deck;

    public UserDeck() {
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    @JsonIgnore
    public Deck getDeck() {
        return deck;
    }

    public void setDeck(final Deck deck) {
        this.deck = deck;
    }

}
