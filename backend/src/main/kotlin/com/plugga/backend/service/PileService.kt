package com.plugga.backend.service

import com.plugga.backend.entity.Pile

interface PileService {
    fun findAll(): MutableList<Pile>

    fun findById(id: Int): Pile?

    fun findByDeckId(id: Int): MutableList<Pile>

    fun save(pile: Pile)

    fun deleteById(id: Int)
}
