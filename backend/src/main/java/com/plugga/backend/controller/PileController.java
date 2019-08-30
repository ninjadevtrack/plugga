package com.plugga.backend.controller;

import com.plugga.backend.entity.Pile;
import com.plugga.backend.service.PileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/piles")
public class PileController {
    private PileService pileService;

    @Autowired
    public PileController(PileService pileService){
        this.pileService = pileService;
    }

    @GetMapping("/")
    public List<Pile> findAll(){
        return pileService.findAll();
    }

    @GetMapping("/{pileId}")
    public Pile getPile(@PathVariable int pileId){
        Pile pile = pileService.findById(pileId);
        if (pile == null){
            throw new RuntimeException("Could not find pile using id: " + pileId);
        }
        return pile;
    }

    @PostMapping("/")
    public Pile addPile(@RequestBody Pile pile){
        pile.setId(0);
        pileService.save(pile);
        return pile;
    }

    @PutMapping("/")
    public Pile updatePile(@RequestBody Pile pile){
        pileService.save(pile);
        return pile;
    }

    @DeleteMapping("/{pileId}")
    public String deletePile(@PathVariable int pileId){
        Pile tempPile = pileService.findById(pileId);
        if (tempPile == null){
            throw new RuntimeException("Could not find pile using id: " + pileId);
        }
        pileService.deleteById(pileId);
        return "Deleted pile with id: " + pileId;
    }
}
