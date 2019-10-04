package com.plugga.backend.dao

import com.plugga.backend.entity.Deck

interface DeckDAO {
    fun findAll(): MutableList<Deck>

    fun findById(id: Int): Deck?

    fun save(deck: Deck)

    fun deleteById(id: Int)
}
