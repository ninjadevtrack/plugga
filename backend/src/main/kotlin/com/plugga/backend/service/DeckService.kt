package com.plugga.backend.service

import com.plugga.backend.entity.Deck
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface DeckService {
    fun findAll(pageable: Pageable): Page<Deck>

    fun findById(id: Int): Deck?

    fun findByUserId(pageable: Pageable, id: Int): Page<Deck>

    fun save(deck: Deck)

    fun deleteById(id: Int)
}
