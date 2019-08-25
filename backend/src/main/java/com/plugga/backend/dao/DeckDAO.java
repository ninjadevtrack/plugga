package com.plugga.backend.dao;

import com.plugga.backend.entity.Deck;

import java.util.List;

public interface DeckDAO {
    public List<Deck> findAll();

    public Deck findById(int id);

    public void save(Deck deck);

    public void deleteById(int id);
}
