package com.plugga.backend.controller;

import com.plugga.backend.entity.DeckCard;
import com.plugga.backend.service.CardService;
import com.plugga.backend.service.DeckCardService;
import com.plugga.backend.service.DeckService;
import com.plugga.backend.service.PileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deck_cards")
public class DeckCardController {
    private DeckCardService deckCardService;
    private DeckService deckService;
    private CardService cardService;
    private PileService pileService;

    @Autowired
    public DeckCardController(DeckCardService deckCardService, DeckService deckService,
            CardService cardService, PileService pileService){

        this.deckCardService = deckCardService;
        this.deckService = deckService;
        this.cardService = cardService;
        this.pileService = pileService;
    }

    @GetMapping("/")
    public List<DeckCard> findAll(){
        return deckCardService.findAll();
    }

    @GetMapping("/{deckCardId}")
    public DeckCard getDeckCard(@PathVariable int deckCardId){
        DeckCard deckCard = deckCardService.findById(deckCardId);
        if (deckCard == null){
            throw new RuntimeException("Could not find deckCard using id: " + deckCardId);
        }
        return deckCard;
    }

    @GetMapping(value = "", params = "deckId")
    public List<DeckCard> getByDeckId(@RequestParam("deckId") int deckId){
        List<DeckCard> deckCards = deckCardService.findByDeckId(deckId);
        if (deckCards == null){
            throw new RuntimeException("Could not find deckCards using deckId: " + deckId);
        }
        return deckCards;
    }

    @GetMapping(value = "", params = "cardId")
    public List<DeckCard> getByCardId(@RequestParam("cardId") int cardId){
        List<DeckCard> deckCards = deckCardService.findByCardId(cardId);
        if (deckCards == null){
            throw new RuntimeException("Could not find deckCards using cardId: " + cardId);
        }
        return deckCards;
    }

    @PostMapping("/")
    public DeckCard addDeckCard(@RequestBody DeckCard deckCard){
        deckCard.setId(0);
        deckCardService.save(deckCard);
        deckCard.setDeck(deckService.findById(deckCard.getDeck().getId()));
        deckCard.setCard(cardService.findById(deckCard.getCard().getId()));
        deckCard.setPile(pileService.findById(deckCard.getPile().getId()));
        return deckCard;
    }

    @PutMapping("/")
    public DeckCard updateDeckCard(@RequestBody DeckCard deckCard){
        deckCardService.save(deckCard);
        deckCard.setDeck(deckService.findById(deckCard.getDeck().getId()));
        deckCard.setCard(cardService.findById(deckCard.getCard().getId()));
        deckCard.setPile(pileService.findById(deckCard.getPile().getId()));
        return deckCard;
    }

    @DeleteMapping("/{deckCardId}")
    public String deleteDeckCard(@PathVariable int deckCardId){
        DeckCard tempDeckCard = deckCardService.findById(deckCardId);
        if (tempDeckCard == null){
            throw new RuntimeException("Could not find deckCard using id: " + deckCardId);
        }
        deckCardService.deleteById(deckCardId);
        return "Deleted deckCard with id: " + deckCardId;
    }
}
