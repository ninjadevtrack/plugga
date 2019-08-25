package com.plugga.backend.dao;

import com.plugga.backend.entity.DeckCard;

import java.util.List;

public interface DeckCardDAO {
    public List<DeckCard> findAll();

    public DeckCard findById(int id);

    public void save(DeckCard deckCard);

    public void deleteById(int id);
}
