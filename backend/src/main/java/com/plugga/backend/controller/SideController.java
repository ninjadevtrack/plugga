package com.plugga.backend.controller;


import com.plugga.backend.entity.Side;
import com.plugga.backend.service.SideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sides")
public class SideController {
    private SideService sideService;

    @Autowired
    public SideController(SideService sideService){
        this.sideService = sideService;
    }

    @GetMapping("/")
    public List<Side> findAll(){
        return sideService.findAll();
    }

    @GetMapping("/{sideId}")
    public Side getSide(@PathVariable int sideId){
        Side side = sideService.findById(sideId);
        if (side == null){
            throw new RuntimeException("Could not find side using id: " + sideId);
        }
        return side;
    }

    @PostMapping("/")
    public Side addSide(@RequestBody Side side){
        side.setId(0);
        sideService.save(side);
        return side;
    }

    @PutMapping("/")
    public Side updateSide(@RequestBody Side side){
        sideService.save(side);
        return side;
    }

    @DeleteMapping("/{sideId}")
    public String deleteSide(@PathVariable int sideId){
        Side tempSide = sideService.findById(sideId);
        if (tempSide == null){
            throw new RuntimeException("Could not find side using id: " + sideId);
        }
        sideService.deleteById(sideId);
        return "Deleted side with id: " + sideId;
    }
}
