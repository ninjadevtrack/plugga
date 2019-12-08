package com.plugga.backend.unit.service

import com.nhaarman.mockito_kotlin.reset
import com.plugga.backend.entity.User
import com.plugga.backend.repository.UserRepository
import com.plugga.backend.service.UserService
import com.plugga.backend.service.UserServiceImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.any
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class UserServiceTest {

    @Mock
    lateinit var userRepository: UserRepository

    @Mock
    lateinit var passwordEncoder: BCryptPasswordEncoder

    @Mock
    lateinit var pageable: Pageable

    lateinit var userService: UserService

    @BeforeEach
    fun setup() {
        userService = UserServiceImpl(userRepository, passwordEncoder)
    }

    @AfterEach
    fun cleanup() {
        reset(userRepository)
        reset(passwordEncoder)
        reset(pageable)
    }

    @Test
    fun `test UserService find all users`() {
        val users: MutableList<User> = mutableListOf()
        users.add(User())

        val pagedUsers: Page<User> = PageImpl<User>(users)
        `when`(userRepository.findAll(pageable)).thenReturn(pagedUsers)

        val returnedUsers: Page<User> = userService.findAll(pageable)
        verify(userRepository).findAll(pageable)
        assertThat(returnedUsers.content).hasSize(1)
    }

    @Test
    fun `test UserService find user by id`() {
        val user = User()
        `when`(userRepository.findById(anyInt())).thenReturn(Optional.of(user))

        val returnedUser = userService.findById(anyInt())
        verify(userRepository).findById(anyInt())
        assertThat(returnedUser).isNotNull
    }

    @Test
    fun `test UserService save() new user`() {
        val insertedName = "testName"
        val insertedEmail = "test@plugga.com"
        val rawPassword = "password"
        val newUser = User(
            insertedName,
            insertedEmail,
            rawPassword
        )
        val returnedUser = userService.save(newUser)

        verify(passwordEncoder).encode(rawPassword)
        verify(userRepository).save(newUser)

        //TODO: verify that updateExistingUserFields() was not called

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
    fun `test UserService save() update user`() {
        //TODO: test UserService.save() with existing user aka id > 0
    }

    @Test
    fun updateExistingUserFields() {
        val userServiceImpl = UserServiceImpl(userRepository, passwordEncoder)
        val updatedUser = userServiceImpl.updateExistingUserFields(any(User::class.java), any(User::class.java))

        verify(userServiceImpl).updateExistingUserName(any(User::class.java), any(User::class.java))
        verify(userServiceImpl).updateExistingUserEmail(any(User::class.java), any(User::class.java))
        verify(userServiceImpl).updateExistingUserPassword(any(User::class.java), any(User::class.java))
        verify(userServiceImpl).updateExistingUserDateCreated(any(User::class.java), any(User::class.java))
        verify(userServiceImpl).updateExistingUserLastLogin(any(User::class.java), any(User::class.java))

        assertThat(updatedUser).isNotNull
    }

    @Nested
    class TestUpdateExistingFields {

        lateinit var existingUser: User
        lateinit var newUserData: User

        @BeforeEach
        fun setup() {
            existingUser = User()
            newUserData = User()
        }

        @Test
        fun updateExistingUserName() {
            //TODO
        }

        @Test
        fun updateExistingUserEmail() {
            //TODO
        }

        @Test
        fun updateExistingUserPassword() {
            //TODO
        }

        @Test
        fun updateExistingUserDateCreated() {
            //TODO
        }

        @Test
        fun updateExistingUserLastLogin() {
            //TODO
        }
    }

    @Test
    fun `test UserService delete user by id`() {
        userService.deleteById(anyInt())
        verify(userRepository).deleteById(anyInt())
    }
}