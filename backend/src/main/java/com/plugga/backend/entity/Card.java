package com.plugga.backend.entity;

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

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", lastUsed=" + lastUsed +
                '}';
    }

    public void add(Side side) {
        if (sides == null) {
            sides = new ArrayList<>();
        }
        sides.add(side);
        side.setCard(this);
    }
}
