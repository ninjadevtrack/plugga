package com.plugga.backend.service

import com.plugga.backend.entity.Side

interface SideService {
    fun findAll(): List<Side>

    fun findById(id: Int): Side

    fun findByCardId(cardId: Int): List<Side>

    fun save(side: Side)

    fun deleteById(id: Int)
}
