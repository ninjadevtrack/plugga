package com.plugga.backend.service;

import com.plugga.backend.dao.DeckCardDAO;
import com.plugga.backend.entity.DeckCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeckCardServiceImpl implements DeckCardService {
    private DeckCardDAO deckCardDAO;

    @Autowired
    public DeckCardServiceImpl(final DeckCardDAO deckCardDAO) {
        this.deckCardDAO = deckCardDAO;
    }

    @Override
    @Transactional
    public List<DeckCard> findAll() {
        return deckCardDAO.findAll();
    }

    @Override
    @Transactional
    public DeckCard findById(final int id) {
        return deckCardDAO.findById(id);
    }

    @Override
    @Transactional
    public List<DeckCard> findByDeckId(final int id) {
        return deckCardDAO.findByDeckId(id);
    }

    @Override
    @Transactional
    public List<DeckCard> findByCardId(final int id) {
        return deckCardDAO.findByCardId(id);
    }

    @Override
    @Transactional
    public void save(final DeckCard deckCard) {
        deckCardDAO.save(deckCard);
    }

    @Override
    @Transactional
    public void deleteById(final int id) {
        deckCardDAO.deleteById(id);
    }
}
