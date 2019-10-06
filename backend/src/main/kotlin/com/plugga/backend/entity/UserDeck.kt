package com.plugga.backend.entity

import com.fasterxml.jackson.annotation.JsonIdentityReference
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "user_deck")
class UserDeck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_deck_id")
    var id: Int = 0

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonIdentityReference(alwaysAsId = true)
    var user: User? = null

    @ManyToOne
    @JoinColumn(name = "deck_id", referencedColumnName = "deck_id")
    @JsonIdentityReference(alwaysAsId = true)
    var deck: Deck? = null

    override fun toString(): String {
        return "UserDeck{" +
                "user=" + user +
                ", deck=" + deck +
                '}'.toString()
    }
}
