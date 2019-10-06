package com.plugga.backend.service

import com.plugga.backend.dao.DeckDAO
import com.plugga.backend.dao.UserDeckDAO
import com.plugga.backend.entity.Deck
import com.plugga.backend.entity.UserDeck
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeckServiceImpl @Autowired
constructor(private val deckDAO: DeckDAO, private val userDeckDAO: UserDeckDAO) : DeckService {

    @Transactional
    override fun findAll(): MutableList<Deck> {
        return deckDAO.findAll()
    }

    @Transactional
    override fun findById(id: Int): Deck? {
        return deckDAO.findById(id)
    }

    @Transactional
    override fun findByUserId(id: Int): MutableList<Deck> {
        val userDecks: MutableList<UserDeck> = userDeckDAO.findByUserId(id)
        val decks: MutableList<Deck> = mutableListOf()
        userDecks?.forEach {
            it.deck?.let { it1 -> decks.add(it1) }
        }
        return decks
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
