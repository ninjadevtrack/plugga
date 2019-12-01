package com.plugga.backend.service

import com.plugga.backend.dao.DeckDAO
import com.plugga.backend.dao.UserDeckDAO
import com.plugga.backend.dao.util.subListForRequestedPage
import com.plugga.backend.entity.Deck
import java.util.Optional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeckServiceImpl @Autowired
constructor(private val deckDAO: DeckDAO, private val userDeckDAO: UserDeckDAO) : DeckService {

    @Transactional
    override fun findAll(pageable: Pageable): Page<Deck> {
        return deckDAO.findAll(pageable)
    }

    @Transactional
    override fun findById(id: Int): Deck? {
        val queryResult: Optional<Deck> = deckDAO.findById(id)
        return if (queryResult.isPresent) queryResult.get() else null
    }

    @Transactional
    override fun findByUserId(pageable: Pageable, id: Int): Page<Deck> {
        val userDeckList = userDeckDAO.findByUserId(id)
        val deckList: MutableList<Deck> = mutableListOf()
        userDeckList.forEach {
            it.deck?.let { it1 -> deckList.add(it1) }
        }
        return PageImpl<Deck>(subListForRequestedPage(pageable, deckList), pageable, deckList.size.toLong())
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
