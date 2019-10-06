package com.plugga.backend.entity

import com.fasterxml.jackson.annotation.JsonIgnore

import javax.persistence.*

@Entity
@Table(name = "side")
class Side {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "side_id")
    var id: Int = 0

    @ManyToOne
    @JoinColumn(name = "card_id", referencedColumnName = "card_id")
    @get:JsonIgnore
    var card: Card? = null

    @Column(name = "image_url")
    var imageUrl: String? = null

    @Column(name = "text")
    var text: String? = null

    constructor() {}

    constructor(id: Int) {
        this.id = id
    }

    constructor(imageUrl: String, text: String) {
        this.imageUrl = imageUrl
        this.text = text
    }

    override fun toString(): String {
        return "Side{" +
                "id=" + id +
                ", card=" + card +
                ", imageUrl='" + imageUrl + '\''.toString() +
                ", text='" + text + '\''.toString() +
                '}'.toString()
    }
}
