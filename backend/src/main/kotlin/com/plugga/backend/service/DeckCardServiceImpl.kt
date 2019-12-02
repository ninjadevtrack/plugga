package com.plugga.backend.service

import com.plugga.backend.repository.DeckCardRepository
import com.plugga.backend.entity.DeckCard
import java.util.Optional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeckCardServiceImpl @Autowired
constructor(private val deckCardRepository: DeckCardRepository) : DeckCardService {

    @Transactional
    override fun findAll(pageable: Pageable): Page<DeckCard> {
        return deckCardRepository.findAll(pageable)
    }

    @Transactional
    override fun findById(id: Int): DeckCard? {
        val queryResult: Optional<DeckCard> = deckCardRepository.findById(id)
        return if (queryResult.isPresent) queryResult.get() else null
    }

    @Transactional
    override fun findByDeckId(pageable: Pageable, id: Int): Page<DeckCard> {
        return deckCardRepository.findByDeckId(pageable, id)
    }

    @Transactional
    override fun findByCardId(pageable: Pageable, id: Int): Page<DeckCard> {
        return deckCardRepository.findByCardId(pageable, id)
    }

    @Transactional
    override fun save(deckCard: DeckCard) {
        deckCardRepository.save(deckCard)
    }

    @Transactional
    override fun deleteById(id: Int) {
        deckCardRepository.deleteById(id)
    }
}
