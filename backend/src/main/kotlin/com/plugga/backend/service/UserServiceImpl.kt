package com.plugga.backend.service

import com.plugga.backend.entity.User
import com.plugga.backend.repository.UserRepository
import java.sql.Timestamp
import java.util.Optional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl @Autowired
constructor(private val userRepository: UserRepository, private val passwordEncoder: PasswordEncoder) : UserService {

    @Transactional
    override fun findAll(pageable: Pageable): Page<User> {
        return userRepository.findAll(pageable)
    }

    @Transactional
    override fun findById(id: Int): User? {
        val queryResult: Optional<User> = userRepository.findById(id)
        return if (queryResult.isPresent) queryResult.get() else null
    }

    @Transactional
    override fun save(user: User): User? {
        user.password?.let {
            user.password = passwordEncoder.encode(it)
        }
        return if (user.id == 0) saveNewUser(user) else updateUser(user)
    }

    fun saveNewUser(user: User): User {
        user.dateCreated = Timestamp(System.currentTimeMillis())
        userRepository.save(user)
        return user
    }

    fun updateUser(user: User): User? {
        val queryResult: Optional<User> = userRepository.findById(user.id)
        if (queryResult.isPresent) {
            val existingUser = queryResult.get()
            userRepository.save(updateExistingUserFields(existingUser, user))
            return existingUser
        }
        return null
    }

    fun updateExistingUserFields(existingUser: User, inputUserData: User): User {
        updateExistingUserName(existingUser, inputUserData)
        updateExistingUserEmail(existingUser, inputUserData)
        updateExistingUserPassword(existingUser, inputUserData)
        updateExistingUserDateCreated(existingUser, inputUserData)
        updateExistingUserLastLogin(existingUser, inputUserData)
        return existingUser
    }

    fun updateExistingUserName(existingUser: User, inputUserData: User) {
        existingUser.name = if (inputUserData.name == null) existingUser.name else inputUserData.name
    }

    fun updateExistingUserEmail(existingUser: User, inputUserData: User) {
        existingUser.email = if (inputUserData.email == null) existingUser.email else inputUserData.email
    }

    fun updateExistingUserPassword(existingUser: User, inputUserData: User) {
        existingUser.password = if (inputUserData.password == null) existingUser.password else inputUserData.password
    }

    fun updateExistingUserDateCreated(existingUser: User, inputUserData: User) {
        existingUser.dateCreated = if (inputUserData.dateCreated == null) existingUser.dateCreated else inputUserData.dateCreated
    }

    fun updateExistingUserLastLogin(existingUser: User, inputUserData: User) {
        existingUser.lastLogin = if (inputUserData.lastLogin == null) existingUser.lastLogin else inputUserData.lastLogin
    }

    @Transactional
    override fun deleteById(id: Int) {
        userRepository.deleteById(id)
    }
}
