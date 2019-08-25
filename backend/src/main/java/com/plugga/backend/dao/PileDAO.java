package com.plugga.backend.dao;

import com.plugga.backend.entity.Pile;

import java.util.List;

public interface PileDAO {
    public List<Pile> findAll();

    public Pile findById(int id);

    public void save(Pile pile);

    public void deleteById(int id);
}
