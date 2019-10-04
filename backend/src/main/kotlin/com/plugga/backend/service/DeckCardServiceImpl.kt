package com.plugga.backend.service

import com.plugga.backend.dao.DeckCardDAO
import com.plugga.backend.entity.DeckCard
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeckCardServiceImpl @Autowired
constructor(private val deckCardDAO: DeckCardDAO) : DeckCardService {

    @Transactional
    override fun findAll(): List<DeckCard> {
        return deckCardDAO.findAll()
    }

    @Transactional
    override fun findById(id: Int): DeckCard {
        return deckCardDAO.findById(id)
    }

    @Transactional
    override fun findByDeckId(id: Int): List<DeckCard> {
        return deckCardDAO.findByDeckId(id)
    }

    @Transactional
    override fun findByCardId(id: Int): List<DeckCard> {
        return deckCardDAO.findByCardId(id)
    }

    @Transactional
    override fun save(deckCard: DeckCard) {
        deckCardDAO.save(deckCard)
    }

    @Transactional
    override fun deleteById(id: Int) {
        deckCardDAO.deleteById(id)
    }
}
