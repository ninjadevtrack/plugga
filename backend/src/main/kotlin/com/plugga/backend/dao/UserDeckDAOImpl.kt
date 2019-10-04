package com.plugga.backend.dao

import com.plugga.backend.entity.UserDeck
import org.hibernate.Session
import org.hibernate.query.Query
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

import javax.persistence.EntityManager

@Repository
class UserDeckDAOImpl @Autowired
constructor(private val entityManager: EntityManager) : UserDeckDAO {

    override fun findAll(): List<UserDeck> {
        val currentSession = entityManager.unwrap(Session::class.java)
        val query = currentSession.createQuery("from UserDeck", UserDeck::class.java)
        return query.resultList
    }

    override fun findById(id: Int): UserDeck {
        val currentSession = entityManager.unwrap(Session::class.java)
        return currentSession.get(UserDeck::class.java, id)
    }

    override fun findByUserId(userId: Int): List<UserDeck> {
        val currentSession = entityManager.unwrap(Session::class.java)
        val query = currentSession.createQuery("from UserDeck where user_id=:userId", UserDeck::class.java)
        query.setParameter("userId", userId)
        return query.resultList
    }

    override fun findByDeckId(deckId: Int): List<UserDeck> {
        val currentSession = entityManager.unwrap(Session::class.java)
        val query = currentSession.createQuery("from UserDeck where deck_id=:deckId", UserDeck::class.java)
        query.setParameter("deckId", deckId)
        return query.resultList
    }

    override fun save(userDeck: UserDeck) {
        val currentSession = entityManager.unwrap(Session::class.java)
        currentSession.saveOrUpdate(userDeck)
    }

    override fun deleteById(id: Int) {
        val currentSession = entityManager.unwrap(Session::class.java)
        val query = currentSession.createQuery("delete from UserDeck where id=:userDeckId")
        query.setParameter("userDeckId", id)
        query.executeUpdate()
    }
}
