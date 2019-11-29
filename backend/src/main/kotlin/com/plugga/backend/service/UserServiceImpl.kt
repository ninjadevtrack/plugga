package com.plugga.backend.service

import com.plugga.backend.dao.UserDAO
import com.plugga.backend.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl @Autowired
constructor(private val userDAO: UserDAO, private val passwordEncoder: PasswordEncoder) : UserService {

    @Transactional
    override fun findAll(): MutableList<User> {
        return userDAO.findAll()
    }

    @Transactional
    override fun findById(id: Int): User? {
        return userDAO.findById(id)
    }

    @Transactional
    override fun save(user: User): User? {
        user.password?.let {
            user.password = passwordEncoder.encode(it)
        }
        if (user.id == 0) {
            userDAO.save(user)
            return user
        }
        val existingUser = userDAO.findById(user.id)
        if (existingUser != null) {
            userDAO.save(updateExistingUserFields(existingUser, user))
        }
        return existingUser
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
        userDAO.deleteById(id)
    }
}
