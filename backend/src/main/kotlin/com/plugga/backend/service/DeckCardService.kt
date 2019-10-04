package com.plugga.backend.service

import com.plugga.backend.entity.DeckCard

interface DeckCardService {
    fun findAll(): List<DeckCard>

    fun findById(id: Int): DeckCard

    fun findByDeckId(id: Int): List<DeckCard>

    fun findByCardId(id: Int): List<DeckCard>

    fun save(deckCard: DeckCard)

    fun deleteById(id: Int)
}
