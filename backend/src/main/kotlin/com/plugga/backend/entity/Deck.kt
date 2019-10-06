package com.plugga.backend.entity

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIdentityReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import com.plugga.backend.jackson.EntityIdResolver

import javax.persistence.*
import java.sql.Timestamp

@Entity
@Table(name = "deck")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator::class,
        property = "id",
        resolver = EntityIdResolver::class,
        scope = Deck::class
)
class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deck_id")
    var id: Int = 0

    @Column(name = "name")
    var name: String? = null

    @Column(name = "image_url")
    var imageUrl: String? = null

    @Column(name = "date_created")
    var dateCreated: Timestamp? = null

    @OneToMany(mappedBy = "deck")
    @get:JsonIgnore
    var cards: MutableList<DeckCard>? = null

    @OneToMany(mappedBy = "deck")
    @get:JsonIgnore
    var users: MutableList<UserDeck>? = null

    constructor() {}

    constructor(id: Int) {
        this.id = id
        this.name = ""
        this.imageUrl = ""
    }

    constructor(name: String, imageUrl: String, dateCreated: Timestamp) {
        this.name = name
        this.imageUrl = imageUrl
        this.dateCreated = dateCreated
    }

    override fun toString(): String {
        return "Deck{" +
                "id=" + id +
                ", name='" + name + '\''.toString() +
                ", imageUrl='" + imageUrl + '\''.toString() +
                ", dateCreated=" + dateCreated +
                '}'.toString()
    }

    fun addCard(card: DeckCard) {
        if (cards == null) {
            cards = mutableListOf()
        }
        cards!!.add(card)
    }
}
