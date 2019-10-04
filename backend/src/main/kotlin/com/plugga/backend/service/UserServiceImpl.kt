package com.plugga.backend.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import com.plugga.backend.dao.UserDAO
import com.plugga.backend.entity.User

@Service
class UserServiceImpl @Autowired
constructor(private val userDAO: UserDAO) : UserService {

    @Transactional
    override fun findAll(): List<User> {
        return userDAO.findAll()
    }

    @Transactional
    override fun findById(id: Int): User {
        return userDAO.findById(id)
    }

    @Transactional
    override fun save(user: User) {
        userDAO.save(user)
    }

    @Transactional
    override fun deleteById(id: Int) {
        userDAO.deleteById(id)
    }

}
