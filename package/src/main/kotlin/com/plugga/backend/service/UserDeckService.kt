package com.plugga.backend.service

import com.plugga.backend.entity.UserDeck

interface UserDeckService {
    fun findAll(): MutableList<UserDeck>

    fun findById(id: Int): UserDeck?

    fun findByDeckId(id: Int): MutableList<UserDeck>

    fun findByUserId(id: Int): MutableList<UserDeck>

    fun save(userCard: UserDeck)

    fun deleteById(id: Int)
}
