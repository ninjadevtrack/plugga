package com.plugga.backend.dao;

import com.plugga.backend.entity.Card;

import java.util.List;

public interface CardDAO {
    List<Card> findAll();

    Card findById(int id);

    void save(Card card);

    void deleteById(int id);
}
