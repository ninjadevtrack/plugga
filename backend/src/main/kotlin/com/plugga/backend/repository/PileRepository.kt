package com.plugga.backend.repository

import com.plugga.backend.entity.Pile
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface PileRepository : PagingAndSortingRepository<Pile, Int> {

    fun findByDeckId(deckId: Int): List<Pile>

    fun findByDeckId(pageable: Pageable, deckId: Int): Page<Pile>
}
