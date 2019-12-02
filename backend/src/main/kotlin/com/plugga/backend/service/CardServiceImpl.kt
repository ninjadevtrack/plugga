package com.plugga.backend.service

import com.plugga.backend.repository.CardRepository
import com.plugga.backend.repository.DeckCardRepository
import com.plugga.backend.repository.util.subListForRequestedPage
import com.plugga.backend.entity.Card
import java.util.Optional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CardServiceImpl @Autowired
constructor(private val cardRepository: CardRepository, private val deckCardRepository: DeckCardRepository) : CardService {

    @Transactional
    override fun findAll(pageable: Pageable): Page<Card> {
        return cardRepository.findAll(pageable)
    }

    @Transactional
    override fun findById(id: Int): Card? {
        val queryResult: Optional<Card> = cardRepository.findById(id)
        return if (queryResult.isPresent) queryResult.get() else null
    }

    @Transactional
    override fun findByDeckId(pageable: Pageable, id: Int): Page<Card> {
        val deckCardList = deckCardRepository.findByDeckId(id)
        val cardList: MutableList<Card> = mutableListOf()
        deckCardList.forEach {
            it.card?.let { it1 -> cardList.add(it1) }
        }
        return PageImpl<Card>(subListForRequestedPage(pageable, cardList), pageable, cardList.size.toLong())
    }

    @Transactional
    override fun save(card: Card) {
        cardRepository.save(card)
    }

    @Transactional
    override fun deleteById(id: Int) {
        cardRepository.deleteById(id)
    }
}
