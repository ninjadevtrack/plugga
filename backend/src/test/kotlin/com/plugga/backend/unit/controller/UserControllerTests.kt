package com.plugga.backend.unit.controller

import com.nhaarman.mockito_kotlin.any
import com.plugga.backend.controller.UserController
import com.plugga.backend.entity.User
import com.plugga.backend.service.UserService
import java.sql.Timestamp
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@ExtendWith(MockitoExtension::class)
class UserControllerTests {

    @Mock
    lateinit var userService: UserService

    @InjectMocks
    lateinit var userController: UserController

    private lateinit var mockMvc: MockMvc

    private lateinit var validUser: User

    private lateinit var passwordEncoder: PasswordEncoder

    @BeforeAll
    fun classSetUp() {
        passwordEncoder = BCryptPasswordEncoder()
    }

    @BeforeEach
    fun setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build()

        val validUserUnencodedPassword = "password"
        val validUserDateCreated = Timestamp(System.currentTimeMillis())
        val validUserLastLogin = Timestamp(System.currentTimeMillis())
        validUser = User(
            1,
            "testName",
            "test@plugga.com",
            passwordEncoder.encode(validUserUnencodedPassword),
            validUserDateCreated,
            validUserLastLogin
        )
    }

    @Test
    fun `Test get User by id`() {
        given(userService.findById(any())).willReturn(validUser)

        mockMvc.perform(get("/api/users/${validUser.id}")).andExpect(status().isOk)
    }
}
