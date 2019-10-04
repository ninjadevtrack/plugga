package com.plugga.backend.service

import com.plugga.backend.dao.UserDeckDAO
import com.plugga.backend.entity.UserDeck
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class UserDeckServiceImpl @Autowired
constructor(private val userDeckDAO: UserDeckDAO) : UserDeckService {

    @Transactional
    override fun findAll(): MutableList<UserDeck> {
        return userDeckDAO.findAll()
    }

    @Transactional
    override fun findById(id: Int): UserDeck? {
        return userDeckDAO.findById(id)
    }

    @Transactional
    override fun findByDeckId(id: Int): MutableList<UserDeck> {
        return userDeckDAO.findByDeckId(id)
    }

    @Transactional
    override fun findByUserId(id: Int): MutableList<UserDeck> {
        return userDeckDAO.findByUserId(id)
    }

    @Transactional
    override fun save(userDeck: UserDeck) {
        userDeckDAO.save(userDeck)
    }

    @Transactional
    override fun deleteById(id: Int) {
        userDeckDAO.deleteById(id)
    }
}
