package com.plugga.backend.dao;

import com.plugga.backend.entity.Card;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CardDAOImpl implements CardDAO {
    private EntityManager entityManager;

    @Autowired
    public CardDAOImpl(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Card> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Card> query = currentSession.createQuery("from Card", Card.class);
        List<Card> cards = query.getResultList();
        return cards;
    }

    @Override
    public Card findById(final int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Card card = currentSession.get(Card.class, id);
        return card;
    }

    @Override
    public void save(final Card card) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(card);
    }

    @Override
    public void deleteById(final int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("delete from Card where id=:cardId");
        query.setParameter("cardId", id);
        query.executeUpdate();
    }
}
