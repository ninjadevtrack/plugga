package com.plugga.backend.service

import com.plugga.backend.entity.User

interface UserService {
    fun findAll(): MutableList<User>

    fun findById(id: Int): User?

    fun save(user: User): User?

    fun deleteById(id: Int)
}
