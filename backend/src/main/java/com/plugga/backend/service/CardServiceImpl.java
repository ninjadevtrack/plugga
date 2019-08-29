package com.plugga.backend.service;

import com.plugga.backend.dao.CardDAO;
import com.plugga.backend.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CardServiceImpl implements CardService {
    private CardDAO carDAO;

    @Autowired
    public CardServiceImpl(final CardDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public List<Card> findAll() {
        return carDAO.findAll();
    }

    @Override
    public Card findById(final int id) {
        return null;
    }

    @Override
    public void save(final Card card) {

    }

    @Override
    public void deleteById(final int id) {

    }
}
