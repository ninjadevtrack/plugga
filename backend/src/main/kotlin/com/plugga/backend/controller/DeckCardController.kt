package com.plugga.backend.controller

import com.plugga.backend.entity.DeckCard
import com.plugga.backend.service.CardService
import com.plugga.backend.service.DeckCardService
import com.plugga.backend.service.DeckService
import com.plugga.backend.service.PileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/deck_cards")
class DeckCardController @Autowired
constructor(private val deckCardService: DeckCardService, private val deckService: DeckService,
            private val cardService: CardService, private val pileService: PileService) {

    @GetMapping("/")
    fun findAll(): List<DeckCard> {
        return deckCardService.findAll()
    }

    @GetMapping("/{deckCardId}")
    fun getDeckCard(@PathVariable deckCardId: Int): DeckCard {
        return deckCardService.findById(deckCardId)
                ?: throw RuntimeException("Could not find deckCard using id: $deckCardId")
    }

    @GetMapping(value = "", params = ["deckId"])
    fun getByDeckId(@RequestParam("deckId") deckId: Int): List<DeckCard> {
        return deckCardService.findByDeckId(deckId)
                ?: throw RuntimeException("Could not find deckCards using deckId: $deckId")
    }

    @GetMapping(value = "", params = ["cardId"])
    fun getByCardId(@RequestParam("cardId") cardId: Int): List<DeckCard> {
        return deckCardService.findByCardId(cardId)
                ?: throw RuntimeException("Could not find deckCards using cardId: $cardId")
    }

    @PostMapping("/")
    fun addDeckCard(@RequestBody deckCard: DeckCard): DeckCard {
        deckCard.id = 0
        deckCardService.save(deckCard)
        deckCard.deck = deckService.findById(deckCard.deck!!.id)
        deckCard.card = cardService.findById(deckCard.card!!.id)
        deckCard.pile = pileService.findById(deckCard.pile!!.id)
        return deckCard
    }

    @PutMapping("/")
    fun updateDeckCard(@RequestBody deckCard: DeckCard): DeckCard {
        deckCardService.save(deckCard)
        deckCard.deck = deckService.findById(deckCard.deck!!.id)
        deckCard.card = cardService.findById(deckCard.card!!.id)
        deckCard.pile = pileService.findById(deckCard.pile!!.id)
        return deckCard
    }

    @DeleteMapping("/{deckCardId}")
    fun deleteDeckCard(@PathVariable deckCardId: Int): String {
        val tempDeckCard = deckCardService.findById(deckCardId)
                ?: throw RuntimeException("Could not find deckCard using id: $deckCardId")
        deckCardService.deleteById(deckCardId)
        return "Deleted deckCard with id: $deckCardId"
    }
}
