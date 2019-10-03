package com.plugga.backend.service;

import com.plugga.backend.entity.Deck;

import java.util.List;

public interface DeckService {
    List<Deck> findAll();

    Deck findById(int id);

    void save(Deck deck);

    void deleteById(int id);
}
