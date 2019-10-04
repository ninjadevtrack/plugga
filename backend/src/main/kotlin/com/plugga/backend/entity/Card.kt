package com.plugga.backend.entity

import com.fasterxml.jackson.annotation.JsonIgnore

import javax.persistence.*
import java.sql.Timestamp

@Entity
@Table(name = "card")
class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    var id: Int = 0

    @Column(name = "last_used")
    var lastUsed: Timestamp? = null

    @OneToMany(mappedBy = "card", cascade = [CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH])
    @get:JsonIgnore
    var sides: MutableList<Side>? = null

    @OneToMany(mappedBy = "card", cascade = [CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH])
    @get:JsonIgnore
    var decks: MutableList<DeckCard>? = null

    constructor() {}

    constructor(id: Int) {
        this.id = id
        this.lastUsed = null
        this.sides = null
        this.decks = null
    }

    constructor(lastUsed: Timestamp) {
        this.lastUsed = lastUsed
    }

    override fun toString(): String {
        return "Card{" +
                "id=" + id +
                ", lastUsed=" + lastUsed +
                '}'.toString()
    }

    fun addSide(side: Side) {
        if (sides == null) {
            sides = mutableListOf()
        }
        sides!!.add(side)
        side.card = this
    }

    fun addDeck(deck: DeckCard) {
        if (decks == null) {
            decks = mutableListOf()
        }
        decks!!.add(deck)
    }
}
