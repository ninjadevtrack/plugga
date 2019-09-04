package com.plugga.backend.controller;

import com.plugga.backend.entity.Card;
import com.plugga.backend.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {
    private CardService cardService;

    @Autowired
    public CardController(CardService cardService){
        this.cardService = cardService;
    }

    @GetMapping("/")
    public List<Card> findAll(){
        return cardService.findAll();
    }

    @GetMapping("/{cardId}")
    public Card getCard(@PathVariable int cardId){
        Card card = cardService.findById(cardId);
        if (card == null){
            throw new RuntimeException("Could not find card using id: " + cardId);
        }
        return card;
    }

    @PostMapping("/")
    public Card addCard(@RequestBody Card card){
        card.setId(0);
        cardService.save(card);
        return card;
    }

    @PutMapping("/")
    public Card updateCard(@RequestBody Card card){
        cardService.save(card);
        return card;
    }

    @DeleteMapping("/{cardId}")
    public String deleteCard(@PathVariable int cardId){
        Card tempCard = cardService.findById(cardId);
        if (tempCard == null){
            throw new RuntimeException("Could not find card using id: " + cardId);
        }
        cardService.deleteById(cardId);
        return "Deleted card with id: " + cardId;
    }
}
