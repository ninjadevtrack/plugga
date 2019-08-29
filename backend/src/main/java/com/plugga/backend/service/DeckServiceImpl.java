package com.plugga.backend.service;

import com.plugga.backend.dao.DeckDAO;
import com.plugga.backend.entity.Deck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeckServiceImpl implements DeckService {
    private DeckDAO deckDAO;

    @Autowired
    public DeckServiceImpl(final DeckDAO deckDAO) {
        this.deckDAO = deckDAO;
    }

    @Override
    @Transactional
    public List<Deck> findAll() {
        return deckDAO.findAll();
    }

    @Override
    @Transactional
    public Deck findById(final int id) {
        return deckDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(final Deck deck) {
        deckDAO.save(deck);
    }

    @Override
    @Transactional
    public void deleteById(final int id) {
        deckDAO.deleteById(id);
    }
}
