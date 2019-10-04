package com.plugga.backend.dao

import com.plugga.backend.entity.Pile

interface PileDAO {
    fun findAll(): MutableList<Pile>

    fun findById(id: Int): Pile?

    fun save(pile: Pile)

    fun deleteById(id: Int)
}
