package com.plugga.backend.dao;

import com.plugga.backend.entity.Card;

import java.util.List;

public interface CardDAO {
    public List<Card> findAll();

    public Card findById(int id);

    public void save(Card card);

    public void deleteById(int id);
}
