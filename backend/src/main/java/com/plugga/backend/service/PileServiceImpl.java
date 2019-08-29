package com.plugga.backend.service;

import com.plugga.backend.dao.PileDAO;
import com.plugga.backend.entity.Pile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PileServiceImpl implements PileService {
    private PileDAO pileDAO;

    @Autowired
    public PileServiceImpl(final PileDAO pileDAO) {
        this.pileDAO = pileDAO;
    }

    @Override
    @Transactional
    public List<Pile> findAll() {
        return pileDAO.findAll();
    }

    @Override
    @Transactional
    public Pile findById(final int id) {
        return pileDAO.findById(id);
    }

    @Override
    @Transactional
    public List<Pile> findByDeckId(final int deckId) {
        return pileDAO.findByDeckId(deckId);
    }

    @Override
    @Transactional
    public void save(final Pile pile) {
        pileDAO.save(pile);
    }

    @Override
    @Transactional
    public void deleteById(final int id) {
        pileDAO.deleteById(id);
    }
}
