package com.plugga.backend.dao;

import com.plugga.backend.entity.Pile;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PileDAOImpl implements PileDAO {
    private EntityManager entityManager;

    @Autowired
    public PileDAOImpl(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Pile> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Pile> query = currentSession.createQuery("from Pile", Pile.class);
        return query.getResultList();
    }

    @Override
    public Pile findById(final int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Pile.class, id);
    }

    @Override
    public void save(final Pile pile) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(pile);
    }

    @Override
    public void deleteById(final int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("delete from Pile where id=:pileId");
        query.setParameter("pileId", id);
        query.executeUpdate();
    }
}
