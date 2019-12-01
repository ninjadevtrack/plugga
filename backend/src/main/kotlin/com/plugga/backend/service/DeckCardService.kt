package com.plugga.backend.service

import com.plugga.backend.entity.DeckCard
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface DeckCardService {
    fun findAll(pageable: Pageable): Page<DeckCard>

    fun findById(id: Int): DeckCard?

    fun findByDeckId(pageable: Pageable, id: Int): Page<DeckCard>

    fun findByCardId(pageable: Pageable, id: Int): Page<DeckCard>

    fun save(deckCard: DeckCard)

    fun deleteById(id: Int)
}
