package com.plugga.backend.controller

import com.plugga.backend.entity.Card
import com.plugga.backend.service.CardService
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
@RequestMapping("/api/cards")
class CardController @Autowired
constructor(private val cardService: CardService) {

    @GetMapping("")
    fun findAll(pageable: Pageable, pagedResourcesAssembler: PagedResourcesAssembler<Card>): PagedModel<EntityModel<Card>> {
        return pagedResourcesAssembler.toModel(cardService.findAll(pageable))
    }

    @GetMapping("/{cardId}")
    fun getCard(@PathVariable cardId: Int): Card {
        return cardService.findById(cardId) ?: throw RuntimeException("Could not find card using id: $cardId")
    }

    @GetMapping(value = [""], params = ["deckId"])
    fun getByDeckId(pageable: Pageable, pagedResourcesAssembler: PagedResourcesAssembler<Card>, @RequestParam("deckId") deckId: Int): PagedModel<EntityModel<Card>> {
        return pagedResourcesAssembler.toModel(cardService.findByDeckId(pageable, deckId))
    }

    @PostMapping("")
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
        cardService.findById(cardId) ?: throw RuntimeException("Could not find card using id: $cardId")
        cardService.deleteById(cardId)
        return "Deleted card with id: $cardId"
    }
}
