package com.plugga.backend.dao

import com.plugga.backend.entity.Deck
import org.hibernate.Session
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

import javax.persistence.EntityManager

@Repository
class DeckDAOImpl @Autowired
constructor(private val entityManager: EntityManager) : DeckDAO {

    override fun findAll(): MutableList<Deck> {
        val currentSession = entityManager.unwrap(Session::class.java)
        val query = currentSession.createQuery("from Deck", Deck::class.java)
        return query.resultList
    }

    override fun findById(id: Int): Deck? {
        val currentSession = entityManager.unwrap(Session::class.java)
        return currentSession.get(Deck::class.java, id)
    }

    override fun save(deck: Deck) {
        val currentSession = entityManager.unwrap(Session::class.java)
        currentSession.saveOrUpdate(deck)
    }

    override fun deleteById(id: Int) {
        val currentSession = entityManager.unwrap(Session::class.java)
        val query = currentSession.createQuery("delete from Deck where id=:deckId")
        query.setParameter("deckId", id)
        query.executeUpdate()
    }
}
