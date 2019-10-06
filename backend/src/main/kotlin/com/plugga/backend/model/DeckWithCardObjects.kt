package com.plugga.backend.model

import com.plugga.backend.entity.Card
import com.plugga.backend.entity.DeckCard

import java.sql.Timestamp

class DeckWithCardObjects(
        var id: Int,
        var name: String?,
        var imageUrl: String?,
        var dateCreated: Timestamp?,
        var cards: MutableList<Card>?
) {
//    var id: Int = 0
//    var name: String? = null
//    var imageUrl: String? = null
//    var dateCreated: Timestamp? = null
//    var cards: MutableList<Card>? = null
    var deckCards: MutableList<DeckCard> = mutableListOf()

    constructor(id: Int, name: String?, imageUrl: String?, dateCreated: Timestamp?) :
            this(id, name, imageUrl, dateCreated, mutableListOf()) {

    }

}