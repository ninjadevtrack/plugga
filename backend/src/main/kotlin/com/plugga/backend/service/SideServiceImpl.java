package com.plugga.backend.service;

import com.plugga.backend.dao.SideDAO;
import com.plugga.backend.entity.Side;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SideServiceImpl implements SideService {
    private SideDAO sideDAO;

    @Autowired
    public SideServiceImpl(final SideDAO sideDAO) {
        this.sideDAO = sideDAO;
    }

    @Override
    @Transactional
    public List<Side> findAll() {
        return sideDAO.findAll();
    }

    @Override
    @Transactional
    public Side findById(final int id) {
        return sideDAO.findById(id);
    }

    @Override
    @Transactional
    public List<Side> findByCardId(final int cardId) {
        return sideDAO.findByCardId(cardId);
    }

    @Override
    @Transactional
    public void save(final Side side) {
        sideDAO.save(side);
    }

    @Override
    @Transactional
    public void deleteById(final int id) {
        sideDAO.deleteById(id);
    }
}
