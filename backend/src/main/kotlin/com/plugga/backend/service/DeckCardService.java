package com.plugga.backend.service;

import com.plugga.backend.entity.DeckCard;

import java.util.List;

public interface DeckCardService {
    List<DeckCard> findAll();

    DeckCard findById(int id);

    List<DeckCard> findByDeckId(int id);

    List<DeckCard> findByCardId(int id);

    void save(DeckCard deckCard);

    void deleteById(int id);
}
