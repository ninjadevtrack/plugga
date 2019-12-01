package com.plugga.backend.service

import com.plugga.backend.dao.DeckCardDAO
import com.plugga.backend.entity.DeckCard
import java.util.Optional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeckCardServiceImpl @Autowired
constructor(private val deckCardDAO: DeckCardDAO) : DeckCardService {

    @Transactional
    override fun findAll(pageable: Pageable): Page<DeckCard> {
        return deckCardDAO.findAll(pageable)
    }

    @Transactional
    override fun findById(id: Int): DeckCard? {
        val queryResult: Optional<DeckCard> = deckCardDAO.findById(id)
        return if (queryResult.isPresent) queryResult.get() else null
    }

    @Transactional
    override fun findByDeckId(pageable: Pageable, id: Int): Page<DeckCard> {
        return deckCardDAO.findByDeckId(pageable, id)
    }

    @Transactional
    override fun findByCardId(pageable: Pageable, id: Int): Page<DeckCard> {
        return deckCardDAO.findByCardId(pageable, id)
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
