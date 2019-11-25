package com.plugga.backend.service

import com.plugga.backend.dao.UserDAO
import com.plugga.backend.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.security.crypto.password.PasswordEncoder

@Service
class UserServiceImpl @Autowired
constructor(private val userDAO: UserDAO) : UserService {

    @Autowired
    private val passwordEncoder: PasswordEncoder? = null

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
            user.password = passwordEncoder!!.encode(it)
        }
        return if (user.id != 0) {
            val fetchedUser = userDAO.findById(user.id)
            if (fetchedUser != null) {
                fetchedUser.name = if (user.name == null) fetchedUser.name else user.name
                fetchedUser.email = if (user.email == null) fetchedUser.email else user.email
                fetchedUser.password = if (user.password == null) fetchedUser.password else user.password
                fetchedUser.dateCreated = if (user.dateCreated == null) fetchedUser.dateCreated else user.dateCreated
                fetchedUser.lastLogin = if (user.lastLogin == null) fetchedUser.lastLogin else user.lastLogin
                userDAO.save(fetchedUser)
                fetchedUser
            } else null
        } else {
            userDAO.save(user)
            user
        }
    }

    @Transactional
    override fun deleteById(id: Int) {
        userDAO.deleteById(id)
    }
}
