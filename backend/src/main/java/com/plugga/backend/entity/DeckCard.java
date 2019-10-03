package com.plugga.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "deck_card")
public class DeckCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deck_card_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "deck_id", referencedColumnName = "deck_id")
    private Deck deck;

    @ManyToOne
    @JoinColumn(name = "card_id", referencedColumnName = "card_id")
    private Card card;

    @OneToOne
    @JoinColumn(name = "pile_id", referencedColumnName = "pile_id")
    private Pile pile;

    public DeckCard() {
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(final Deck deck) {
        this.deck = deck;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(final Card card) {
        this.card = card;
    }

    public Pile getPile() {
        return pile;
    }

    public void setPile(final Pile pile) {
        this.pile = pile;
    }

    @Override
    public String toString() {
        return "DeckCard{" +
                "id=" + id +
                ", deck=" + deck +
                ", card=" + card +
                ", pile=" + pile +
                '}';
    }
}
