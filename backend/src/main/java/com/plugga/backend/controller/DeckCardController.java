package com.plugga.backend.controller;

import com.plugga.backend.entity.DeckCard;
import com.plugga.backend.service.DeckCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deck_cards")
public class DeckCardController {
    private DeckCardService deckCardService;

    @Autowired
    public DeckCardController(DeckCardService deckCardService){
        this.deckCardService = deckCardService;
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

    // "/api/deck_cards?deckId=200"
    @GetMapping(value = "", params = "deckId")
    public List<DeckCard> getByDeckId(@RequestParam("deckId") int deckId){
        List<DeckCard> deckCards = deckCardService.findByDeckId(deckId);
        if (deckCards == null){
            throw new RuntimeException("Could not find deckCards using deckId: " + deckId);
        }
        return deckCards;
    }

    // "/api/deck_cards?cardId=200"
    @GetMapping(value = "", params = "cardId")
    public List<DeckCard> getByCardId(@RequestParam("cardId") int cardId){
        List<DeckCard> deckCards = deckCardService.findByCardId(cardId);
        if (deckCards == null){
            throw new RuntimeException("Could not find deckCards using cardId: " + cardId);
        }
        return deckCards;
    }

//    @PostMapping("/")
//    public User addUser(@RequestBody User user){
//        user.setId(0);
//        user.setDateCreated(new Timestamp(System.currentTimeMillis()));
//        userService.save(user);
//        return user;
//    }
//
//    @PutMapping("/")
//    public User updateUser(@RequestBody User user){
//        userService.save(user);
//        return user;
//    }
//
//    @DeleteMapping("/{userId}")
//    public String deleteUser(@PathVariable int userId){
//        User tempUser = userService.findById(userId);
//        if (tempUser == null){
//            throw new RuntimeException("Could not find user using id: " + userId);
//        }
//        userService.deleteById(userId);
//        return "Deleted user with id: " + userId;
//    }
}
