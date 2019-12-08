package com.plugga.backend.unit.service

import com.nhaarman.mockito_kotlin.reset
import com.plugga.backend.entity.User
import com.plugga.backend.repository.UserRepository
import com.plugga.backend.service.UserService
import com.plugga.backend.service.UserServiceImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.util.*

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
        val user = User()
        `when`(userRepository.findById(1)).thenReturn(Optional.of(user))

        val returnedUser = userService.findById(1)
        assertThat(returnedUser).isNotNull
        verify(userRepository).findById(1)
    }

    @Test
    fun saveUser() {
        val insertedName = "testName"
        val insertedEmail = "test@plugga.com"
        val rawPassword = "password"

        val newUser = User(
            insertedName,
            insertedEmail,
            rawPassword
        )
        val returnedUser = userService.saveUser(newUser)

        verify(passwordEncoder).encode(rawPassword)
        verify(userRepository).save(newUser)

        assertThat(returnedUser).isNotNull
        if (returnedUser != null) {
            assertThat(returnedUser.name).isEqualTo(insertedName)
            assertThat(returnedUser.email).isEqualTo(insertedEmail)
            assertThat(returnedUser.password).isNotEqualTo(rawPassword)
            assertThat(returnedUser.dateCreated).isNotNull()
            assertThat(returnedUser.lastLogin).isNull()
        }
    }

    @Test
    fun deleteById() {
        userService.deleteById(1)
        verify(userRepository).deleteById(1)
    }
}