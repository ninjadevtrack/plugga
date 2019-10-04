package com.plugga.backend.service

import com.plugga.backend.entity.Pile

interface PileService {
    fun findAll(): List<Pile>

    fun findById(id: Int): Pile

    fun save(pile: Pile)

    fun deleteById(id: Int)
}
