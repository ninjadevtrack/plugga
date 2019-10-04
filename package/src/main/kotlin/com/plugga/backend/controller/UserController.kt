package com.plugga.backend.controller

import java.sql.Timestamp

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import com.plugga.backend.entity.User
import com.plugga.backend.service.UserService

@RestController
@RequestMapping("/api/users")
class UserController @Autowired
constructor(private val userService: UserService) {

    @GetMapping("/")
    fun findAll(): List<User> {
        return userService.findAll()
    }

    @GetMapping("/{userId}")
    fun getUser(@PathVariable userId: Int): User {
        return userService.findById(userId) ?: throw RuntimeException("Could not find user using id: $userId")
    }

    @PostMapping("/")
    fun addUser(@RequestBody user: User): User {
        user.id = 0
        user.dateCreated = Timestamp(System.currentTimeMillis())
        userService.save(user)
        return user
    }

    @PutMapping("/")
    fun updateUser(@RequestBody user: User): User {
        userService.save(user)
        return user
    }

    @DeleteMapping("/{userId}")
    fun deleteUser(@PathVariable userId: Int): String {
        userService.findById(userId) ?: throw RuntimeException("Could not find user using id: $userId")
        userService.deleteById(userId)
        return "Deleted user with id: $userId"
    }
}
