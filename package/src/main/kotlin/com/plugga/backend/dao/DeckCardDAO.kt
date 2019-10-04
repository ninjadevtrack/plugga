package com.plugga.backend.dao

import com.plugga.backend.entity.DeckCard

interface DeckCardDAO {
    fun findAll(): MutableList<DeckCard>

    fun findById(id: Int): DeckCard?

    fun findByDeckId(deckId: Int): MutableList<DeckCard>

    fun findByCardId(cardId: Int): MutableList<DeckCard>

    fun save(deckCard: DeckCard)

    fun deleteById(id: Int)
}
