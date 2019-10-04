package com.plugga.backend.service

import com.plugga.backend.entity.Side

interface SideService {
    fun findAll(): MutableList<Side>

    fun findById(id: Int): Side?

    fun findByCardId(cardId: Int): MutableList<Side>

    fun save(side: Side)

    fun deleteById(id: Int)
}
