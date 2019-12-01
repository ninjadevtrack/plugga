package com.plugga.backend.service

import com.plugga.backend.entity.UserDeck
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface UserDeckService {
    fun findAll(pageable: Pageable): Page<UserDeck>

    fun findById(id: Int): UserDeck?

    fun findByDeckId(pageable: Pageable, id: Int): Page<UserDeck>

    fun findByUserId(pageable: Pageable, id: Int): Page<UserDeck>

    fun save(userDeck: UserDeck)

    fun deleteById(id: Int)
}
