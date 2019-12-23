package com.plugga.backend.repository

import com.plugga.backend.entity.UserDeck
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface UserDeckRepository : PagingAndSortingRepository<UserDeck, Int> {

    fun findByUserId(userId: Int): List<UserDeck>

    fun findByUserId(pageable: Pageable, userId: Int): Page<UserDeck>

    fun findByDeckId(deckId: Int): List<UserDeck>

    fun findByDeckId(pageable: Pageable, deckId: Int): Page<UserDeck>
}
