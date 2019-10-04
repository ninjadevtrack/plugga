package com.plugga.backend.dao;

import com.plugga.backend.entity.UserDeck;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDeckDAOImpl implements UserDeckDAO {
    private EntityManager entityManager;

    @Autowired
    public UserDeckDAOImpl(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<UserDeck> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<UserDeck> query = currentSession.createQuery("from UserDeck", UserDeck.class);
        return query.getResultList();
    }

    @Override
    public UserDeck findById(final int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(UserDeck.class, id);
    }

    @Override
    public List<UserDeck> findByUserId(final int userId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<UserDeck> query = currentSession.createQuery("from UserDeck where user_id=:userId", UserDeck.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public List<UserDeck> findByDeckId(final int deckId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<UserDeck> query = currentSession.createQuery("from UserDeck where deck_id=:deckId", UserDeck.class);
        query.setParameter("deckId", deckId);
        return query.getResultList();
    }

    @Override
    public void save(final UserDeck userDeck) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(userDeck);
    }

    @Override
    public void deleteById(final int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("delete from UserDeck where id=:userDeckId");
        query.setParameter("userDeckId", id);
        query.executeUpdate();
    }
}
