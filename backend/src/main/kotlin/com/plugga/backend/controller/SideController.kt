package com.plugga.backend.controller

import com.plugga.backend.entity.Side
import com.plugga.backend.service.SideService
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
@RequestMapping("/api/sides")
class SideController @Autowired
constructor(private val sideService: SideService) {

    @GetMapping("")
    fun findAll(pageable: Pageable, pagedResourcesAssembler: PagedResourcesAssembler<Side>): PagedModel<EntityModel<Side>> {
        return pagedResourcesAssembler.toModel(sideService.findAll(pageable))
    }

    @GetMapping("/{sideId}")
    fun getSide(@PathVariable sideId: Int): Side {
        return sideService.findById(sideId) ?: throw RuntimeException("Could not find side using id: $sideId")
    }

    @GetMapping(value = [""], params = ["cardId"])
    fun getByCardId(pageable: Pageable, pagedResourcesAssembler: PagedResourcesAssembler<Side>, @RequestParam("cardId") cardId: Int): PagedModel<EntityModel<Side>> {
        return pagedResourcesAssembler.toModel(sideService.findByCardId(pageable, cardId))
    }

    @PostMapping("")
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
