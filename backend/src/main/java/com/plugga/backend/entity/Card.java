package com.plugga.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private int id;

    @Column(name = "last_used")
    private Timestamp lastUsed;

    @OneToMany(mappedBy = "card",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Side> sides;

    @OneToMany(mappedBy = "card",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<DeckCard> decks;

    public Card() {
    }

    public Card(final Timestamp lastUsed) {
        this.lastUsed = lastUsed;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Timestamp getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(final Timestamp lastUsed) {
        this.lastUsed = lastUsed;
    }

    @JsonIgnore
    public List<Side> getSides() {
        return sides;
    }

    public void setSides(final List<Side> sides) {
        this.sides = sides;
    }

    @JsonIgnore
    public List<DeckCard> getDecks() {
        return decks;
    }

    public void setDecks(final List<DeckCard> decks) {
        this.decks = decks;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", lastUsed=" + lastUsed +
                '}';
    }

    public void addSide(Side side) {
        if (sides == null) {
            sides = new ArrayList<>();
        }
        sides.add(side);
        side.setCard(this);
    }

    public void addDeck(DeckCard deck) {
        if (decks == null) {
            decks = new ArrayList<>();
        }
        decks.add(deck);
    }
}
