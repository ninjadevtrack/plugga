package com.plugga.backend.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.plugga.backend.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

    private EntityManager entityManager;
    
    @Autowired
    public UserDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    @Override
    public List<User> findAll() {
        
        Session currentSession = entityManager.unwrap(Session.class);
        Query<User> query = currentSession.createQuery("from User", User.class);
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    public User findById(int id) {
        
        Session currentSession = entityManager.unwrap(Session.class);
        User user = currentSession.get(User.class, id);
        return user;
    }

    @Override
    public void save(User user) {
        
        Session currentSession = entityManager.unwrap(Session.class);
        /*
         * For saveOrUpdate(), if the id == 0, it will save/insert
         * Else it will update that entity
         */
        currentSession.saveOrUpdate(user);
    }

    @Override
    public void deleteById(int id) {
        
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("delete from User where id=:userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }

}
