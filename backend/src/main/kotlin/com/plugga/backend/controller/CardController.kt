package com.plugga.backend.controller

import com.plugga.backend.entity.Card
import com.plugga.backend.service.CardService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cards")
class CardController @Autowired
constructor(private val cardService: CardService) {

    @GetMapping("/")
    fun findAll(): List<Card> {
        return cardService.findAll()
    }

    @GetMapping("/{cardId}")
    fun getCard(@PathVariable cardId: Int): Card {
        return cardService.findById(cardId) ?: throw RuntimeException("Could not find card using id: $cardId")
    }

    @PostMapping("/")
    fun addCard(@RequestBody card: Card): Card {
        card.id = 0
        cardService.save(card)
        return card
    }

    @PutMapping("/")
    fun updateCard(@RequestBody card: Card): Card {
        cardService.save(card)
        return card
    }

    @DeleteMapping("/{cardId}")
    fun deleteCard(@PathVariable cardId: Int): String {
        val tempCard = cardService.findById(cardId) ?: throw RuntimeException("Could not find card using id: $cardId")
        cardService.deleteById(cardId)
        return "Deleted card with id: $cardId"
    }
}
