package com.plugga.backend.service;

import com.plugga.backend.dao.UserDeckDAO;
import com.plugga.backend.entity.UserDeck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDeckServiceImpl implements UserDeckService {
    private UserDeckDAO userDeckDAO;

    @Autowired
    public UserDeckServiceImpl(final UserDeckDAO userDeckDAO) {
        this.userDeckDAO = userDeckDAO;
    }

    @Override
    @Transactional
    public List<UserDeck> findAll() {
        return userDeckDAO.findAll();
    }

    @Override
    @Transactional
    public UserDeck findById(final int id) {
        return userDeckDAO.findById(id);
    }

    @Override
    @Transactional
    public List<UserDeck> findByDeckId(final int id) {
        return userDeckDAO.findByDeckId(id);
    }

    @Override
    @Transactional
    public List<UserDeck> findByUserId(final int id) {
        return userDeckDAO.findByUserId(id);
    }

    @Override
    @Transactional
    public void save(final UserDeck userDeck) {
        userDeckDAO.save(userDeck);
    }

    @Override
    @Transactional
    public void deleteById(final int id) {
        userDeckDAO.deleteById(id);
    }
}
