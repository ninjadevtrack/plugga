package com.plugga.backend.service;

import com.plugga.backend.entity.Deck;

import java.util.List;

public interface DeckService {
    public List<Deck> findAll();

    public Deck findById(int id);

    public void save(Deck deck);

    public void deleteById(int id);
}
