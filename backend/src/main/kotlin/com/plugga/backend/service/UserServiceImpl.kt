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
    override fun saveUser(user: User): User? {
        user.password?.let {
            user.password = passwordEncoder.encode(it)
        }
        if (user.id == 0) {
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

    private fun updateExistingUserFields(existingUser: User, user: User): User {
        existingUser.name = if (user.name == null) existingUser.name else user.name
        existingUser.email = if (user.email == null) existingUser.email else user.email
        existingUser.password = if (user.password == null) existingUser.password else user.password
        existingUser.dateCreated = if (user.dateCreated == null) existingUser.dateCreated else user.dateCreated
        existingUser.lastLogin = if (user.lastLogin == null) existingUser.lastLogin else user.lastLogin
        return existingUser
    }

    @Transactional
    override fun deleteById(id: Int) {
        userRepository.deleteById(id)
    }
}
