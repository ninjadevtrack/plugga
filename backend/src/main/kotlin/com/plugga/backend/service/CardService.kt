package com.plugga.backend.service

import com.plugga.backend.entity.Card

interface CardService {
    fun findAll(): List<Card>

    fun findById(id: Int): Card?

    fun save(card: Card)

    fun deleteById(id: Int)
}
