package com.plugga.backend.dao;

import com.plugga.backend.entity.UserDeck;

import java.util.List;

public interface UserDeckDAO {
    List<UserDeck> findAll();

    UserDeck findById(int id);

    List<UserDeck> findByUserId(int userId);

    List<UserDeck> findByDeckId(int deckId);

    void save(UserDeck userDeck);

    void deleteById(int id);
}
