package com.plugga.backend.dao;

import com.plugga.backend.entity.Deck;

import java.util.List;

public interface DeckDAO {
    List<Deck> findAll();

    Deck findById(int id);

    void save(Deck deck);

    void deleteById(int id);
}
