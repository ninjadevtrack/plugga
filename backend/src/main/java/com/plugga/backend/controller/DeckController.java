package com.plugga.backend.controller;

import com.plugga.backend.entity.Deck;
import com.plugga.backend.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/decks")
public class DeckController {
    private DeckService deckService;

    @Autowired
    public DeckController(DeckService deckService){
        this.deckService = deckService;
    }

    @GetMapping("/")
    public List<Deck> findAll(){
        return deckService.findAll();
    }

    @GetMapping("/{deckId}")
    public Deck getDeck(@PathVariable int deckId){
        Deck deck = deckService.findById(deckId);
        if (deck == null){
            throw new RuntimeException("Could not find deck using id: " + deckId);
        }
        return deck;
    }

    @PostMapping("/")
    public Deck addDeck(@RequestBody Deck deck){
        deck.setId(0);
        deck.setDateCreated(new Timestamp(System.currentTimeMillis()));
        deckService.save(deck);
        return deck;
    }

    @PutMapping("/")
    public Deck updateDeck(@RequestBody Deck deck){
        deckService.save(deck);
        return deck;
    }

    @DeleteMapping("/{deckId}")
    public String deleteDeck(@PathVariable int deckId){
        Deck tempDeck = deckService.findById(deckId);
        if (tempDeck == null){
            throw new RuntimeException("Could not find deck using id: " + deckId);
        }
        deckService.deleteById(deckId);
        return "Deleted user with id: " + deckId;
    }
}
