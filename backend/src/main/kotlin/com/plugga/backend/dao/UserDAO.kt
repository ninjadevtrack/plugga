package com.plugga.backend.dao

import com.plugga.backend.entity.User

interface UserDAO {
    fun findAll(): MutableList<User>

    fun findById(id: Int): User?

    fun save(user: User)

    fun deleteById(id: Int)
}
