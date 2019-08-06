package com.plugga.backend.entity;

import javax.persistence.*;

@Entity
@Table(name="pile")
public class Pile {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="pile_id")
    private int id;

    @OneToOne()
    @JoinColumn(name="deck_id")
    private Deck deck;

    @Column(name="rank")
    private byte rank;

    @Column(name="freq")
    private byte freq;
}
