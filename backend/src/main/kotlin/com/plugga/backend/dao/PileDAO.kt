package com.plugga.backend.dao

import com.plugga.backend.entity.Pile

interface PileDAO {
    fun findAll(): MutableList<Pile>

    fun findById(id: Int): Pile?

    fun findByDeckId(deckId: Int): MutableList<Pile>

    fun save(pile: Pile)

    fun deleteById(id: Int)
}
