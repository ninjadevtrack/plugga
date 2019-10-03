package com.plugga.backend.controller;

import com.plugga.backend.entity.UserDeck;
import com.plugga.backend.entity.UserDeck;
import com.plugga.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user_decks")
public class UserDeckController {
    private UserDeckService userDeckService;
//    private DeckService deckService;
//    private CardService cardService;
//    private PileService pileService;

    @Autowired
    public UserDeckController(UserDeckService userDeckService){
        this.userDeckService = userDeckService;
    }

    @GetMapping("/")
    public List<UserDeck> findAll(){
        return userDeckService.findAll();
    }

    @GetMapping("/{userDeckId}")
    public UserDeck getUserDeck(@PathVariable int userDeckId){
        UserDeck userDeck = userDeckService.findById(userDeckId);
        if (userDeck == null){
            throw new RuntimeException("Could not find userDeck using id: " + userDeckId);
        }
        return userDeck;
    }

    @GetMapping(value = "", params = "deckId")
    public List<UserDeck> getByDeckId(@RequestParam("deckId") int deckId){
        List<UserDeck> userDecks = userDeckService.findByDeckId(deckId);
        if (userDecks == null){
            throw new RuntimeException("Could not find userDecks using deckId: " + deckId);
        }
        return userDecks;
    }

    @GetMapping(value = "", params = "userId")
    public List<UserDeck> getByUserId(@RequestParam("userId") int userId){
        List<UserDeck> userDecks = userDeckService.findByUserId(userId);
        if (userDecks == null){
            throw new RuntimeException("Could not find userDecks using cardId: " + userId);
        }
        return userDecks;
    }

//    @PostMapping("/")
//    public DeckCard addDeckCard(@RequestBody DeckCard deckCard){
//        deckCard.setId(0);
//        deckCardService.save(deckCard);
//        deckCard.setDeck(deckService.findById(deckCard.getDeck().getId()));
//        deckCard.setCard(cardService.findById(deckCard.getCard().getId()));
//        deckCard.setPile(pileService.findById(deckCard.getPile().getId()));
//        return deckCard;
//    }
//
//    @PutMapping("/")
//    public DeckCard updateDeckCard(@RequestBody DeckCard deckCard){
//        deckCardService.save(deckCard);
//        deckCard.setDeck(deckService.findById(deckCard.getDeck().getId()));
//        deckCard.setCard(cardService.findById(deckCard.getCard().getId()));
//        deckCard.setPile(pileService.findById(deckCard.getPile().getId()));
//        return deckCard;
//    }
//
//    @DeleteMapping("/{deckCardId}")
//    public String deleteDeckCard(@PathVariable int deckCardId){
//        DeckCard tempDeckCard = deckCardService.findById(deckCardId);
//        if (tempDeckCard == null){
//            throw new RuntimeException("Could not find deckCard using id: " + deckCardId);
//        }
//        deckCardService.deleteById(deckCardId);
//        return "Deleted deckCard with id: " + deckCardId;
//    }
}
