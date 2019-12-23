package com.plugga.backend.service

import com.plugga.backend.entity.UserDeck
import com.plugga.backend.repository.UserDeckRepository
import java.util.Optional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class UserDeckServiceImpl @Autowired
constructor(private val userDeckRepository: UserDeckRepository) : UserDeckService {

    @Transactional
    override fun findAll(pageable: Pageable): Page<UserDeck> {
        return userDeckRepository.findAll(pageable)
    }

    @Transactional
    override fun findById(id: Int): UserDeck? {
        val queryResult: Optional<UserDeck> = userDeckRepository.findById(id)
        return if (queryResult.isPresent) queryResult.get() else null
    }

    @Transactional
    override fun findByDeckId(pageable: Pageable, id: Int): Page<UserDeck> {
        return userDeckRepository.findByDeckId(pageable, id)
    }

    @Transactional
    override fun findByUserId(pageable: Pageable, id: Int): Page<UserDeck> {
        return userDeckRepository.findByUserId(pageable, id)
    }

    @Transactional
    override fun save(userDeck: UserDeck) {
        userDeckRepository.save(userDeck)
    }

    @Transactional
    override fun deleteById(id: Int) {
        userDeckRepository.deleteById(id)
    }
}
