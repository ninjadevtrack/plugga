package com.plugga.backend.controller

import com.plugga.backend.entity.Pile
import com.plugga.backend.service.PileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/piles")
class PileController @Autowired
constructor(private val pileService: PileService) {

    @GetMapping("/")
    fun findAll(): List<Pile> {
        return pileService.findAll()
    }

    @GetMapping("/{pileId}")
    fun getPile(@PathVariable pileId: Int): Pile {
        return pileService.findById(pileId) ?: throw RuntimeException("Could not find pile using id: $pileId")
    }

    @PostMapping("/")
    fun addPile(@RequestBody pile: Pile): Pile {
        pile.id = 0
        pileService.save(pile)
        return pile
    }

    @PutMapping("/")
    fun updatePile(@RequestBody pile: Pile): Pile {
        pileService.save(pile)
        return pile
    }

    @DeleteMapping("/{pileId}")
    fun deletePile(@PathVariable pileId: Int): String {
        val tempPile = pileService.findById(pileId) ?: throw RuntimeException("Could not find pile using id: $pileId")
        pileService.deleteById(pileId)
        return "Deleted pile with id: $pileId"
    }
}
