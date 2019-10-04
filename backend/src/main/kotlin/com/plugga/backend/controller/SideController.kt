package com.plugga.backend.controller


import com.plugga.backend.entity.Side
import com.plugga.backend.entity.UserDeck
import com.plugga.backend.service.SideService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/sides")
class SideController @Autowired
constructor(private val sideService: SideService) {

    @GetMapping("/")
    fun findAll(): List<Side> {
        return sideService.findAll()
    }

    @GetMapping("/{sideId}")
    fun getSide(@PathVariable sideId: Int): Side {
        return sideService.findById(sideId) ?: throw RuntimeException("Could not find side using id: $sideId")
    }

    @GetMapping(value = [""], params = ["cardId"])
    fun getByCardId(@RequestParam("cardId") cardId: Int): List<Side> {
        return sideService.findByCardId(cardId)
    }

    @PostMapping("/")
    fun addSide(@RequestBody side: Side): Side {
        side.id = 0
        sideService.save(side)
        return side
    }

    @PutMapping("/")
    fun updateSide(@RequestBody side: Side): Side {
        sideService.save(side)
        return side
    }

    @DeleteMapping("/{sideId}")
    fun deleteSide(@PathVariable sideId: Int): String {
        sideService.findById(sideId) ?: throw RuntimeException("Could not find side using id: $sideId")
        sideService.deleteById(sideId)
        return "Deleted side with id: $sideId"
    }
}
