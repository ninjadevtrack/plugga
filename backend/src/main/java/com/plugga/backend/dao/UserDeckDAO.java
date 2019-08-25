package com.plugga.backend.dao;

import com.plugga.backend.entity.UserDeck;

import java.util.List;

public interface UserDeckDAO {
    public List<UserDeck> findAll();

    public UserDeck findById(int id);

    public void save(UserDeck userDeck);

    public void deleteById(int id);
}
