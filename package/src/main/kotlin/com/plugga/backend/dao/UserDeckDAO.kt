package com.plugga.backend.dao

import com.plugga.backend.entity.UserDeck

interface UserDeckDAO {
    fun findAll(): MutableList<UserDeck>

    fun findById(id: Int): UserDeck?

    fun findByUserId(userId: Int): MutableList<UserDeck>

    fun findByDeckId(deckId: Int): MutableList<UserDeck>

    fun save(userDeck: UserDeck)

    fun deleteById(id: Int)
}
