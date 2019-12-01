package com.plugga.backend.service

import com.plugga.backend.entity.Pile
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface PileService {
    fun findAll(pageable: Pageable): Page<Pile>

    fun findById(id: Int): Pile?

    fun findByDeckId(pageable: Pageable, id: Int): Page<Pile>

    fun save(pile: Pile)

    fun deleteById(id: Int)
}
