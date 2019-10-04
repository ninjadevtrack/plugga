package com.plugga.backend.service

import com.plugga.backend.dao.CardDAO
import com.plugga.backend.entity.Card
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CardServiceImpl @Autowired
constructor(private val cardDAO: CardDAO) : CardService {

    @Transactional
    override fun findAll(): MutableList<Card> {
        return cardDAO.findAll()
    }

    @Transactional
    override fun findById(id: Int): Card? {
        return cardDAO.findById(id)
    }

    @Transactional
    override fun save(card: Card) {
        cardDAO.save(card)
    }

    @Transactional
    override fun deleteById(id: Int) {
        cardDAO.deleteById(id)
    }
}
