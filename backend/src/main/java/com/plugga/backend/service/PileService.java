package com.plugga.backend.service;

import com.plugga.backend.entity.Pile;

import java.util.List;

public interface PileService {
    List<Pile> findAll();

    Pile findById(int id);

    void save(Pile pile);

    void deleteById(int id);
}
