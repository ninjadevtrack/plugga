package com.plugga.backend.service

import com.plugga.backend.dao.DeckDAO
import com.plugga.backend.entity.Deck
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeckServiceImpl @Autowired
constructor(private val deckDAO: DeckDAO) : DeckService {

    @Transactional
    override fun findAll(): MutableList<Deck> {
        return deckDAO.findAll()
    }

    @Transactional
    override fun findById(id: Int): Deck? {
        return deckDAO.findById(id)
    }

    @Transactional
    override fun save(deck: Deck) {
        deckDAO.save(deck)
    }

    @Transactional
    override fun deleteById(id: Int) {
        deckDAO.deleteById(id)
    }
}
