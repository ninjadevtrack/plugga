package com.plugga.backend.entity;

import javax.persistence.*;

@Entity
@Table(name="pile")
public class Pile {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="pile_id")
    private int id;

    @ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="deck_id")
    private Deck deck;

    @Column(name="rank")
    private byte rank;

    @Column(name="freq")
    private byte freq;

    public Pile() {
    }

    public Pile(final byte rank, final byte freq) {
        this.rank = rank;
        this.freq = freq;
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

    public byte getRank() {
        return rank;
    }

    public void setRank(final byte rank) {
        this.rank = rank;
    }

    public byte getFreq() {
        return freq;
    }

    public void setFreq(final byte freq) {
        this.freq = freq;
    }

    @Override
    public String toString() {
        return "Pile{" +
                "id=" + id +
                ", deck=" + deck +
                ", rank=" + rank +
                ", freq=" + freq +
                '}';
    }
}
