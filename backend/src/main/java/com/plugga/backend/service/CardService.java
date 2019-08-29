package com.plugga.backend.service;

import com.plugga.backend.entity.Card;

import java.util.List;

public interface CardService {
    List<Card> findAll();

    Card findById(int id);

    void save(Card card);

    void deleteById(int id);
}
