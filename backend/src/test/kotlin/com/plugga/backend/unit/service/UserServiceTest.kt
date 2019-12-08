package com.plugga.backend.unit.service

import com.nhaarman.mockito_kotlin.reset
import com.plugga.backend.entity.User
import com.plugga.backend.repository.UserRepository
import com.plugga.backend.service.UserService
import com.plugga.backend.service.UserServiceImpl
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


@ExtendWith(MockitoExtension::class)
internal class UserServiceTest {

    @Mock
    lateinit var userRepository: UserRepository

    @Mock
    lateinit var passwordEncoder: BCryptPasswordEncoder

    lateinit var userService: UserService

    @BeforeEach
    fun setup() {
        userService = UserServiceImpl(userRepository, passwordEncoder)
    }

    @AfterEach
    fun cleanup() {
        reset(userRepository)
        reset(passwordEncoder)
    }

    @Test
    fun findAll() {
    }

    @Test
    fun findById() {
    }

    @Test
    fun saveUser() {
        val newUser = User(
            "testName",
            "test@plugga.com",
            "password"
        )
        userService.saveUser(newUser)
        verify(passwordEncoder).encode("password")
        verify(userRepository).save(newUser)
    }

    @Test
    fun deleteById() {
        userService.deleteById(1)
        verify(userRepository).deleteById(1)
    }
}