package com.plugga.backend.repository

import com.plugga.backend.entity.DeckCard
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface DeckCardRepository : PagingAndSortingRepository<DeckCard, Int> {

    fun findByDeckId(deckId: Int): List<DeckCard>

    fun findByDeckId(pageable: Pageable, deckId: Int): Page<DeckCard>

    fun findByCardId(cardId: Int): List<DeckCard>

    fun findByCardId(pageable: Pageable, cardId: Int): Page<DeckCard>
}
