package com.plugga.backend.service

import com.plugga.backend.dao.CardDAO
import com.plugga.backend.dao.DeckCardDAO
import com.plugga.backend.entity.Card
import com.plugga.backend.entity.DeckCard
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CardServiceImpl @Autowired
constructor(private val cardDAO: CardDAO, private val deckCardDAO: DeckCardDAO) : CardService {

    @Transactional
    override fun findAll(): MutableList<Card> {
        return cardDAO.findAll()
    }

    @Transactional
    override fun findById(id: Int): Card? {
        return cardDAO.findById(id)
    }

    @Transactional
    override fun findByDeckId(id: Int): MutableList<Card> {
        val deckCards: MutableList<DeckCard> = deckCardDAO.findByDeckId(id)
        val cards: MutableList<Card> = mutableListOf()
        deckCards?.forEach {
            it.card?.let { it1 -> cards.add(it1) }
        }
        return cards
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
