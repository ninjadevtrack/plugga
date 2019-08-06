package com.plugga.backend.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="card")
public class Card {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="card_id")
    private int id;

    @Column(name="last_used")
    private Timestamp lastUsed;

    @ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="pile_id")
    private int pile;

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

    public int getPile() {
        return pile;
    }

    public void setPile(final int pile) {
        this.pile = pile;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", lastUsed=" + lastUsed +
                ", pile=" + pile +
                '}';
    }
}
