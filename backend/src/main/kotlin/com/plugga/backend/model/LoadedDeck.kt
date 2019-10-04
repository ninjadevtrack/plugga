package com.plugga.backend.model

import com.plugga.backend.entity.Card

import java.sql.Timestamp

class LoadedDeck {
    var id: Int = 0
    var name: String? = null
    var imageUrl: String? = null
    var dateCreated: Timestamp? = null
    var cards: MutableList<Card>? = null
}