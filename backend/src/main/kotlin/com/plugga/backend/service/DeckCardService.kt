package com.plugga.backend.service

import com.plugga.backend.entity.DeckCard

interface DeckCardService {
    fun findAll(): MutableList<DeckCard>

    fun findById(id: Int): DeckCard?

    fun findByDeckId(id: Int): MutableList<DeckCard>

    fun findByCardId(id: Int): MutableList<DeckCard>

    fun save(deckCard: DeckCard)

    fun deleteById(id: Int)
}
