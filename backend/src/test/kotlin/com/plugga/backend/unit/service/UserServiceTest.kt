package com.plugga.backend.unit.service

import com.nhaarman.mockito_kotlin.reset
import com.plugga.backend.entity.User
import com.plugga.backend.repository.UserRepository
import com.plugga.backend.service.UserService
import com.plugga.backend.service.UserServiceImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.sql.Timestamp
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
    fun `test UserService delete user by id`() {
        userService.deleteById(anyInt())
        verify(userRepository).deleteById(anyInt())
    }

    @Nested
    inner class TestUpdateExistingFields {

        lateinit var existingUser: User

        lateinit var inputUserData: User

        lateinit var userServiceImpl: UserServiceImpl

        private val existingName = "name"
        private val existingEmail = "test@test.com"
        private val existingPassword = "Passw0rd"
        private val timeInMilli: Long = System.currentTimeMillis()

//        @Test
//        fun `test updateExistingUserFields`() {
////            val userServiceImpl = UserServiceImpl(userRepository, passwordEncoder)
////            userServiceImpl.updateExistingUserFields(existingUser, newUserData)
//            userServiceImpl.updateExistingUserFields(existingUser, newUserData)
//
//            verify(userServiceImpl).updateExistingUserName(any(), any())
//            verify(userServiceImpl).updateExistingUserEmail(any(), any())
//            verify(userServiceImpl).updateExistingUserPassword(any(), any())
//            verify(userServiceImpl).updateExistingUserDateCreated(any(), any())
//            verify(userServiceImpl).updateExistingUserLastLogin(any(), any())
//        }

        @BeforeEach
        fun setup() {
            userServiceImpl = UserServiceImpl(userRepository, passwordEncoder)

            existingUser = User()
            existingUser.name = existingName
            existingUser.email = existingEmail
            existingUser.password = existingPassword
            existingUser.dateCreated = Timestamp(timeInMilli)
            existingUser.lastLogin = Timestamp(timeInMilli)

            inputUserData = User()
        }

        @Test
        fun `test updateExistingUserName assert name does not change when input name is null`() {
            userServiceImpl.updateExistingUserName(existingUser, inputUserData)
            assertEquals(existingName, existingUser.name)
        }

        @Test
        fun `test updateExistingUserName assert name changes when input is not null`() {
            val newName = "newName"
            inputUserData.name = newName
            userServiceImpl.updateExistingUserName(existingUser, inputUserData)
            assertEquals(newName, existingUser.name)
        }

        @Test
        fun `test updateExistingUserEmail assert email does not change when input is null`() {
            userServiceImpl.updateExistingUserEmail(existingUser, inputUserData)
            assertEquals(existingEmail, existingUser.email)
        }

        @Test
        fun `test updateExistingUserEmail assert email changes when input is not null`() {
            val newEmail = "new@email.com"
            inputUserData.email = newEmail
            userServiceImpl.updateExistingUserEmail(existingUser, inputUserData)
            assertEquals(newEmail, existingUser.email)
        }

        @Test
        fun `test updateExistingUserPassword assert password does not change when input is null`() {
            userServiceImpl.updateExistingUserPassword(existingUser, inputUserData)
            assertEquals(existingPassword, existingUser.password)
        }

        @Test
        fun `test updateExistingUserPassword assert password changes when input is not null`() {
            val newPassword = "newPassword"
            inputUserData.password = newPassword
            userServiceImpl.updateExistingUserPassword(existingUser, inputUserData)
            assertEquals(newPassword, existingUser.password)
        }

        @Test
        fun `test updateExistingUserDateCreated assert dateCreated does not change when input is null`() {
            userServiceImpl.updateExistingUserDateCreated(existingUser, inputUserData)
            assertEquals(timeInMilli, existingUser.dateCreated!!.time)
        }

        @Test
        fun `test updateExistingUserDateCreated assert dateCreated changes when input is not null`() {
            val newDateCreated = Timestamp(System.currentTimeMillis())
            inputUserData.dateCreated = newDateCreated
            userServiceImpl.updateExistingUserDateCreated(existingUser, inputUserData)
            assertEquals(newDateCreated.time, existingUser.dateCreated!!.time)
        }

        @Test
        fun `test updateExistingUserLastLogin assert lastLogin does not change when input is null`() {
            userServiceImpl.updateExistingUserLastLogin(existingUser, inputUserData)
            assertEquals(timeInMilli, existingUser.dateCreated!!.time)
        }

        @Test
        fun `test updateExistingUserLastLogin assert lastLogin changes when input is not null`() {
            val newLastLogin = Timestamp(System.currentTimeMillis())
            inputUserData.lastLogin = newLastLogin
            userServiceImpl.updateExistingUserLastLogin(existingUser, inputUserData)
            assertEquals(newLastLogin.time, existingUser.lastLogin!!.time)
        }
    }
}