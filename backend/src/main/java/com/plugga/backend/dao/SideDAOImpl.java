package com.plugga.backend.dao;

import com.plugga.backend.entity.Side;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class SideDAOImpl implements SideDAO {
    private EntityManager entityManager;

    @Autowired
    public SideDAOImpl(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Side> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Side> query = currentSession.createQuery("from Side", Side.class);
        return query.getResultList();
    }

    @Override
    public Side findById(final int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Side.class, id);
    }

    @Override
    public List<Side> findByCardId(final int cardId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Side> query = currentSession.createQuery("from Side where card=:cardId", Side.class);
        query.setParameter("cardId", cardId);
        return query.getResultList();
    }

    @Override
    public void save(final Side side) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(side);
    }

    @Override
    public void deleteById(final int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("delete from Side where id=:sideId");
        query.setParameter("sideId", id);
        query.executeUpdate();
    }
}
