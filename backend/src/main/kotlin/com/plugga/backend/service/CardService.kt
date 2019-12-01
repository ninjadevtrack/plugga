package com.plugga.backend.service

import com.plugga.backend.entity.Card
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface CardService {
    fun findAll(pageable: Pageable): Page<Card>

    fun findById(id: Int): Card?

    fun findByDeckId(pageable: Pageable, id: Int): Page<Card>

    fun save(card: Card)

    fun deleteById(id: Int)
}
