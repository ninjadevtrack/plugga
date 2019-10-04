package com.plugga.backend.dao;

import com.plugga.backend.entity.Pile;

import java.util.List;

public interface PileDAO {
    List<Pile> findAll();

    Pile findById(int id);

    void save(Pile pile);

    void deleteById(int id);
}
