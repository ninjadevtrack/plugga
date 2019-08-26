package com.plugga.backend.dao;

import com.plugga.backend.entity.DeckCard;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DeckCardDAOImpl implements DeckCardDAO {
    private EntityManager entityManager;

    @Autowired
    public DeckCardDAOImpl(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<DeckCard> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<DeckCard> query = currentSession.createQuery("from DeckCard", DeckCard.class);
        return query.getResultList();
    }

    @Override
    public DeckCard findById(final int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(DeckCard.class, id);
    }

    @Override
    public List<DeckCard> findByDeckId(final int deckId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<DeckCard> query = currentSession.createQuery("from DeckCard where deck=:deckId", DeckCard.class);
        query.setParameter("deckId", deckId);
        return query.getResultList();
    }

    @Override
    public List<DeckCard> findByCardId(final int cardId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<DeckCard> query = currentSession.createQuery("from DeckCard where card=:cardId", DeckCard.class);
        query.setParameter("cardId", cardId);
        return query.getResultList();
    }

    @Override
    public void save(final DeckCard deckCard) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(deckCard);
    }

    @Override
    public void deleteById(final int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("delete from DeckCard where id=:deckCardId");
        query.setParameter("deckCardId", id);
        query.executeUpdate();
    }
}
