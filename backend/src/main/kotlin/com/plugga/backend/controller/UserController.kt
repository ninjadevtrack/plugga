package com.plugga.backend.controller

import com.plugga.backend.entity.User
import com.plugga.backend.service.UserService
import java.sql.Timestamp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PagedResourcesAssembler
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.PagedModel
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController @Autowired
constructor(private val userService: UserService) {

    @GetMapping("")
    fun findAll(pageable: Pageable, pagedResourcesAssembler: PagedResourcesAssembler<User>): PagedModel<EntityModel<User>> {
        return pagedResourcesAssembler.toModel(userService.findAll(pageable))
    }

    @GetMapping("/{userId}")
    fun getUser(@PathVariable userId: Int): User {
        return userService.findById(userId) ?: throw RuntimeException("Could not find user using id: $userId")
    }

    @PostMapping("")
    fun addUser(@RequestBody user: User): User {
        user.id = 0
        user.dateCreated = Timestamp(System.currentTimeMillis())
        userService.saveUser(user)
        return user
    }

    @PutMapping("/{userId}")
    fun updateUser(@PathVariable userId: Int, @RequestBody user: User): User {
        if (user.dateCreated != null) {
            throw java.lang.RuntimeException("dateCreated cannot be updated")
        }
        user.id = userId
        val updatedUser = userService.saveUser(user)
        return updatedUser ?: throw java.lang.RuntimeException("Error updating")
    }

    @DeleteMapping("/{userId}")
    fun deleteUser(@PathVariable userId: Int): String {
        userService.findById(userId) ?: throw RuntimeException("Could not find user using id: $userId")
        userService.deleteById(userId)
        return "Deleted user with id: $userId"
    }
}
