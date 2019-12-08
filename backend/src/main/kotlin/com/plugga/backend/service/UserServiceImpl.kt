package com.plugga.backend.service

import com.plugga.backend.repository.UserRepository
import com.plugga.backend.entity.User
import java.util.Optional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.sql.Timestamp

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
        if (user.id == 0) {
            user.dateCreated = Timestamp(System.currentTimeMillis())
            userRepository.save(user)
            return user
        }
        val queryResult: Optional<User> = userRepository.findById(user.id)
        if (queryResult.isPresent) {
            val existingUser = queryResult.get()
            userRepository.save(updateExistingUserFields(existingUser, user))
            return existingUser
        }
        return null
    }

    fun updateExistingUserFields(existingUser: User, newUserData: User): User {
        updateExistingUserName(existingUser, newUserData)
        updateExistingUserEmail(existingUser, newUserData)
        updateExistingUserPassword(existingUser, newUserData)
        updateExistingUserDateCreated(existingUser, newUserData)
        updateExistingUserLastLogin(existingUser, newUserData)
        return existingUser
    }

    fun updateExistingUserName(existingUser: User, newUserData: User) {
        existingUser.name = if (newUserData.name == null) existingUser.name else newUserData.name
    }

    fun updateExistingUserEmail(existingUser: User, newUserData: User) {
        existingUser.email = if (newUserData.email == null) existingUser.email else newUserData.email
    }

    fun updateExistingUserPassword(existingUser: User, newUserData: User) {
        existingUser.password = if (newUserData.password == null) existingUser.password else newUserData.password
    }

    fun updateExistingUserDateCreated(existingUser: User, newUserData: User) {
        existingUser.dateCreated = if (newUserData.dateCreated == null) existingUser.dateCreated else newUserData.dateCreated
    }

    fun updateExistingUserLastLogin(existingUser: User, newUserData: User) {
        existingUser.lastLogin = if (newUserData.lastLogin == null) existingUser.lastLogin else newUserData.lastLogin
    }

    @Transactional
    override fun deleteById(id: Int) {
        userRepository.deleteById(id)
    }
}
