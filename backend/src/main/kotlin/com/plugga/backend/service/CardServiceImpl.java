package com.plugga.backend.service;

import com.plugga.backend.dao.CardDAO;
import com.plugga.backend.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    private CardDAO cardDAO;

    @Autowired
    public CardServiceImpl(final CardDAO carDAO) {
        this.cardDAO = carDAO;
    }

    @Override
    @Transactional
    public List<Card> findAll() {
        return cardDAO.findAll();
    }

    @Override
    @Transactional
    public Card findById(final int id) {
        return cardDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(final Card card) {
        cardDAO.save(card);
    }

    @Override
    @Transactional
    public void deleteById(final int id) {
        cardDAO.deleteById(id);
    }
}
