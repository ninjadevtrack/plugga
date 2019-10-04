package com.plugga.backend.entity

import com.fasterxml.jackson.annotation.JsonIdentityReference
import javax.persistence.*

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
    var pile: Pile? = null

    constructor() {}

    override fun toString(): String {
        return "DeckCard{" +
                "id=" + id +
                ", deck=" + deck +
                ", card=" + card +
                ", pile=" + pile +
                '}'.toString()
    }
}
