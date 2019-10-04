package com.plugga.backend.service;

import com.plugga.backend.entity.UserDeck;

import java.util.List;

public interface UserDeckService {
    List<UserDeck> findAll();

    UserDeck findById(int id);

    List<UserDeck> findByDeckId(int id);

    List<UserDeck> findByUserId(int id);

    void save(UserDeck userCard);

    void deleteById(int id);
}
