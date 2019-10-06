package com.plugga.backend.entity

import com.fasterxml.jackson.annotation.JsonIdentityReference
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "deck_card")
class DeckCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deck_card_id")
    var id: Int = 0

    @ManyToOne
    @JoinColumn(name = "deck_id", referencedColumnName = "deck_id")
    @JsonIdentityReference(alwaysAsId = true)
    var deck: Deck? = null

    @ManyToOne
    @JoinColumn(name = "card_id", referencedColumnName = "card_id")
    @JsonIdentityReference(alwaysAsId = true)
    var card: Card? = null

    @OneToOne
    @JoinColumn(name = "pile_id", referencedColumnName = "pile_id")
    @JsonIdentityReference(alwaysAsId = true)
    var pile: Pile? = null

    constructor() {}

    constructor(id: Int) {
        this.id = id
    }

    override fun toString(): String {
        return "DeckCard{" +
                "id=" + id +
                ", deck=" + deck +
                ", card=" + card +
                ", pile=" + pile +
                '}'.toString()
    }
}
