package com.plugga.backend.service

import com.plugga.backend.entity.Deck

interface DeckService {
    fun findAll(): MutableList<Deck>

    fun findById(id: Int): Deck?

    fun save(deck: Deck)

    fun deleteById(id: Int)
}
