package com.plugga.backend.service

import com.plugga.backend.entity.Side
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface SideService {
    fun findAll(pageable: Pageable): Page<Side>

    fun findById(id: Int): Side?

    fun findByCardId(pageable: Pageable, cardId: Int): Page<Side>

    fun save(side: Side)

    fun deleteById(id: Int)
}
