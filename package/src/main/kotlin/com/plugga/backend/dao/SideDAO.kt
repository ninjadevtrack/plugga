package com.plugga.backend.dao

import com.plugga.backend.entity.Side

interface SideDAO {
    fun findAll(): MutableList<Side>

    fun findById(id: Int): Side?

    fun findByCardId(cardId: Int): MutableList<Side>

    fun save(side: Side)

    fun deleteById(id: Int)
}
