package com.plugga.backend.dao

import com.plugga.backend.entity.Card

interface CardDAO {
    fun findAll(): MutableList<Card>

    fun findById(id: Int): Card?

    fun save(card: Card)

    fun deleteById(id: Int)
}
