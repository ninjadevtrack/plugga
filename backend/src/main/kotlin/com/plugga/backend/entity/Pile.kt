package com.plugga.backend.entity

import com.fasterxml.jackson.annotation.JsonIdentityReference
import javax.persistence.*

@Entity
@Table(name = "pile")
class Pile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pile_id")
    var id: Int = 0

    @ManyToOne
    @JoinColumn(name = "deck_id", referencedColumnName = "deck_id")
    @JsonIdentityReference(alwaysAsId = true)
    var deck: Deck? = null

    @Column(name = "rank")
    var rank: Byte = 0

    @Column(name = "freq")
    var freq: Int = 0

    constructor() {}

    constructor(id: Int) {
        this.id = id
    }

    constructor(rank: Byte, freq: Int) {
        this.rank = rank
        this.freq = freq
    }

    override fun toString(): String {
        return "Pile{" +
                "id=" + id +
                ", rank=" + rank +
                ", freq=" + freq +
                '}'.toString()
    }
}
