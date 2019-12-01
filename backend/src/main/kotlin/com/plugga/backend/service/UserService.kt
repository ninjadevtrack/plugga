package com.plugga.backend.service

import com.plugga.backend.entity.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface UserService {

    fun findAll(pageable: Pageable): Page<User>

    fun findById(id: Int): User?

    fun saveUser(user: User): User?

    fun deleteById(id: Int)
}
