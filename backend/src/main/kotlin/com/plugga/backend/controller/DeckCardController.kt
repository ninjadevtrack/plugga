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

    @GetMapping(value = [""], params = ["deckId"])
    fun getByDeckId(@RequestParam("deckId") deckId: Int): List<DeckCard> {
        return deckCardService.findByDeckId(deckId)
    }

    @GetMapping(value = [""], params = ["cardId"])
    fun getByCardId(@RequestParam("cardId") cardId: Int): List<DeckCard> {
        return deckCardService.findByCardId(cardId)
    }

    @PostMapping("/")
    fun addDeckCard(@RequestBody deckCard: DeckCard): DeckCard {
        deckCard.id = 0
        deckCardService.save(deckCard)
        updateReturnDeckCard(deckCard)
        return deckCard
    }

    @PutMapping("/")
    fun updateDeckCard(@RequestBody deckCard: DeckCard): DeckCard {
        deckCardService.save(deckCard)
        updateReturnDeckCard(deckCard)
        return deckCard
    }

    @DeleteMapping("/{deckCardId}")
    fun deleteDeckCard(@PathVariable deckCardId: Int): String {
        deckCardService.findById(deckCardId) ?: throw RuntimeException("Could not find deckCard using id: $deckCardId")
        deckCardService.deleteById(deckCardId)
        return "Deleted deckCard with id: $deckCardId"
    }

    private fun updateReturnDeckCard(deckCard: DeckCard) {
        deckCard.deck = deckService.findById(deckCard.deck!!.id)
        deckCard.card = cardService.findById(deckCard.card!!.id)
        deckCard.pile?.let {
            deckCard.pile = pileService.findById(it.id)
        }
    }
}
