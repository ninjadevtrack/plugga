package com.plugga.backend.controller

import com.plugga.backend.entity.Deck
import com.plugga.backend.service.DeckService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

import java.sql.Timestamp

@RestController
@RequestMapping("/api/decks")
class DeckController @Autowired
constructor(private val deckService: DeckService) {

    @GetMapping("/")
    fun findAll(): List<Deck> {
        return deckService.findAll()
    }

    @GetMapping("/{deckId}")
    fun getDeck(@PathVariable deckId: Int): Deck {
        return deckService.findById(deckId) ?: throw RuntimeException("Could not find deck using id: $deckId")
    }

    @GetMapping(value = [""], params = ["userId"])
    fun getByUserId(@RequestParam("userId") userId: Int): List<Deck> {
        return deckService.findByUserId(userId)
    }

    @PostMapping("/")
    fun addDeck(@RequestBody deck: Deck): Deck {
        deck.id = 0
        deck.dateCreated = Timestamp(System.currentTimeMillis())
        deckService.save(deck)
        return deck
    }

    @PutMapping("/")
    fun updateDeck(@RequestBody deck: Deck): Deck {
        deckService.save(deck)
        return deck
    }

    @DeleteMapping("/{deckId}")
    fun deleteDeck(@PathVariable deckId: Int): String {
        deckService.findById(deckId) ?: throw RuntimeException("Could not find deck using id: $deckId")
        deckService.deleteById(deckId)
        return "Deleted user with id: $deckId"
    }
}
