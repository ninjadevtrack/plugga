package com.plugga.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_deck")
public class UserDeck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_deck_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "deck_id", referencedColumnName = "deck_id")
    private Deck deck;

    public UserDeck() {
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(final Deck deck) {
        this.deck = deck;
    }

    @Override
    public String toString() {
        return "UserDeck{" +
                "user=" + user +
                ", deck=" + deck +
                '}';
    }
}
