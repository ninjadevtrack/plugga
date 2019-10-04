package com.plugga.backend.dao;

import com.plugga.backend.entity.Deck;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DeckDAOImpl implements DeckDAO {
    private EntityManager entityManager;

    @Autowired
    public DeckDAOImpl(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Deck> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Deck> query = currentSession.createQuery("from Deck", Deck.class);
        return query.getResultList();
    }

    @Override
    public Deck findById(final int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Deck.class, id);
    }

    @Override
    public void save(final Deck deck) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(deck);
    }

    @Override
    public void deleteById(final int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("delete from Deck where id=:deckId");
        query.setParameter("deckId", id);
        query.executeUpdate();
    }
}
