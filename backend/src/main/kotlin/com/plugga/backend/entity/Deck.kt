package com.plugga.backend.entity

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import com.plugga.backend.jackson.EntityIdResolver
import java.sql.Timestamp
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

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

    @Column(name = "date_created", updatable = false)
    var dateCreated: Timestamp? = null

    @OneToMany(mappedBy = "deck")
    @get:JsonIgnore
    var cards: MutableList<DeckCard>? = null

    @OneToMany(mappedBy = "deck")
    @get:JsonIgnore
    var users: MutableList<UserDeck>? = null

    @OneToMany(mappedBy = "deck")
    @get:JsonIgnore
    var piles: MutableList<Pile>? = null

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
