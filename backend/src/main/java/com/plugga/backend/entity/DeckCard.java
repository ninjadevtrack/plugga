package com.plugga.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "deck_card")
public class DeckCard {



    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "pile_id")
    private int pile;
}
