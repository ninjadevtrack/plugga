package com.plugga.backend.entity

import javax.persistence.*

@Entity
@Table(name = "user_deck")
class UserDeck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_deck_id")
    var id: Int = 0

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    var user: User? = null

    @ManyToOne
    @JoinColumn(name = "deck_id", referencedColumnName = "deck_id")
    var deck: Deck? = null

    override fun toString(): String {
        return "UserDeck{" +
                "user=" + user +
                ", deck=" + deck +
                '}'.toString()
    }
}
