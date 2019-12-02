package com.plugga.backend.controller

import com.plugga.backend.entity.DeckCard
import com.plugga.backend.service.CardService
import com.plugga.backend.service.DeckCardService
import com.plugga.backend.service.DeckService
import com.plugga.backend.service.PileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PagedResourcesAssembler
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.PagedModel
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/deck_cards")
class DeckCardController
@Autowired
constructor(
    private val deckCardService: DeckCardService,
    private val deckService: DeckService,
    private val cardService: CardService,
    private val pileService: PileService
) {

    @GetMapping("")
    fun findAll(
        pageable: Pageable,
        pagedResourcesAssembler: PagedResourcesAssembler<DeckCard>
    ): PagedModel<EntityModel<DeckCard>> {
        return pagedResourcesAssembler.toModel(deckCardService.findAll(pageable))
    }

    @GetMapping("/{deckCardId}")
    fun getDeckCard(@PathVariable deckCardId: Int): DeckCard {
        return deckCardService.findById(deckCardId)
            ?: throw RuntimeException("Could not find deckCard using id: $deckCardId")
    }

    @GetMapping(value = [""], params = ["deckId"])
    fun getByDeckId(
        pageable: Pageable,
        pagedResourcesAssembler: PagedResourcesAssembler<DeckCard>,
        @RequestParam("deckId") deckId: Int
    ): PagedModel<EntityModel<DeckCard>> {
        return pagedResourcesAssembler.toModel(deckCardService.findByDeckId(pageable, deckId))
    }

    @GetMapping(value = [""], params = ["cardId"])
    fun getByCardId(
        pageable: Pageable,
        pagedResourcesAssembler: PagedResourcesAssembler<DeckCard>,
        @RequestParam("cardId") cardId: Int
    ): PagedModel<EntityModel<DeckCard>> {
        return pagedResourcesAssembler.toModel(deckCardService.findByCardId(pageable, cardId))
    }

    @PostMapping("")
    fun addDeckCard(@RequestBody deckCard: DeckCard): DeckCard {
        deckCard.id = 0
        deckCardService.save(deckCard)
        updateReturnDeckCard(deckCard)
        return deckCard
    }

    @PutMapping("/{deckCardId}")
    fun updateDeckCard(@PathVariable deckCardId: Int, @RequestBody deckCard: DeckCard): DeckCard {
        deckCard.id = deckCardId
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
