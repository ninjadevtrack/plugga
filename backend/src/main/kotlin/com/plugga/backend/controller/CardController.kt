package com.plugga.backend.controller

import com.plugga.backend.entity.Card
import com.plugga.backend.entity.Deck
import com.plugga.backend.entity.DeckCard
import com.plugga.backend.entity.Side
import com.plugga.backend.service.CardService
import com.plugga.backend.service.DeckCardService
import com.plugga.backend.service.DeckService
import com.plugga.backend.service.SideService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cards")
class CardController @Autowired
constructor(private val cardService: CardService,
            private val deckCardService: DeckCardService, private val sideService: SideService) {

    @GetMapping("/")
    fun findAll(): List<Card> {
        return cardService.findAll()
    }

    @GetMapping("/{cardId}")
    fun getCard(@PathVariable cardId: Int): Card {
        return cardService.findById(cardId) ?: throw RuntimeException("Could not find card using id: $cardId")
    }

    @GetMapping(value = [""], params = ["deckId"])
    fun getByDeckId(@RequestParam("deckId") deckId: Int): List<Card> {
        return cardService.findByDeckId(deckId)
    }

    @PostMapping("/")
    fun addCard(@RequestBody card: Card): Card {
        card.id = 0
        cardService.save(card)

        val updatedSides: MutableList<Side> = mutableListOf()
        if (card.sides != null) {
            for (side in card.sides!!) {
                val tempSide = sideService.findById(side.id)
                if (tempSide != null) {
                    updatedSides.add(tempSide)
                }
            }
        }

        val updatedDeckCards: MutableList<DeckCard> = mutableListOf()
        if (card.decks != null) {
            for (deckCard in card.decks!!) {
                val tempDeckCard = deckCardService.findById(deckCard.id)
                if (tempDeckCard != null) {
                    updatedDeckCards.add(tempDeckCard)
                }
            }
        }

        card.sides = updatedSides
        card.decks = updatedDeckCards
        return card
    }

    @PutMapping("/")
    fun updateCard(@RequestBody card: Card): Card {
        cardService.save(card)
        return card
    }

    @DeleteMapping("/{cardId}")
    fun deleteCard(@PathVariable cardId: Int): String {
        cardService.findById(cardId) ?: throw RuntimeException("Could not find card using id: $cardId")
        cardService.deleteById(cardId)
        return "Deleted card with id: $cardId"
    }
}
