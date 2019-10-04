package com.plugga.backend.dao;

import com.plugga.backend.entity.DeckCard;

import java.util.List;

public interface DeckCardDAO {
    List<DeckCard> findAll();

    DeckCard findById(int id);

    List<DeckCard> findByDeckId(int deckId);

    List<DeckCard> findByCardId(int cardId);

    void save(DeckCard deckCard);

    void deleteById(int id);
}
