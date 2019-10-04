package com.plugga.backend.controller

import com.plugga.backend.entity.DeckCard
import com.plugga.backend.entity.UserDeck
import com.plugga.backend.service.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user_decks")
class UserDeckController @Autowired
constructor(private val userDeckService: UserDeckService, private val deckService: DeckService, private val userService: UserService) {

    @GetMapping("/")
    fun findAll(): List<UserDeck> {
        return userDeckService.findAll()
    }

    @GetMapping("/{userDeckId}")
    fun getUserDeck(@PathVariable userDeckId: Int): UserDeck {
        return userDeckService.findById(userDeckId)
                ?: throw RuntimeException("Could not find userDeck using id: $userDeckId")
    }

    @GetMapping(value = [""], params = ["deckId"])
    fun getByDeckId(@RequestParam("deckId") deckId: Int): List<UserDeck> {
        return userDeckService.findByDeckId(deckId)
    }

    @GetMapping(value = [""], params = ["userId"])
    fun getByUserId(@RequestParam("userId") userId: Int): List<UserDeck> {
        return userDeckService.findByUserId(userId)
    }

    @PostMapping("/")
    fun addUserDeck(@RequestBody userDeck: UserDeck): UserDeck {
        userDeck.id = 0
        userDeckService.save(userDeck)
        userDeck.deck = deckService.findById(userDeck.deck!!.id)
        userDeck.user = userService.findById(userDeck.user!!.id)
        return userDeck
    }

    @PutMapping("/")
    fun updateUserDeck(@RequestBody userDeck: UserDeck): UserDeck {
        userDeckService.save(userDeck)
        userDeck.deck = deckService.findById(userDeck.deck!!.id)
        userDeck.user = userService.findById(userDeck.user!!.id)
        return userDeck
    }

    @DeleteMapping("/{userDeckId}")
    fun deleteUserDeck(@PathVariable userDeckId: Int): String {
        userDeckService.findById(userDeckId)?: throw RuntimeException("Could not find userDeck using id: $userDeckId")
        userDeckService.deleteById(userDeckId)
        return "Deleted userDeck with id: $userDeckId"
    }
}
