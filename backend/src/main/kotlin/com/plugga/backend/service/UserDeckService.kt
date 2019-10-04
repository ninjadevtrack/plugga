package com.plugga.backend.service

import com.plugga.backend.entity.UserDeck

interface UserDeckService {
    fun findAll(): List<UserDeck>

    fun findById(id: Int): UserDeck

    fun findByDeckId(id: Int): List<UserDeck>

    fun findByUserId(id: Int): List<UserDeck>

    fun save(userCard: UserDeck)

    fun deleteById(id: Int)
}
