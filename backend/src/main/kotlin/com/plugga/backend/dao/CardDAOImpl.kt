package com.plugga.backend.dao

import com.plugga.backend.entity.Card
import org.hibernate.Session
import org.hibernate.query.Query
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

import javax.persistence.EntityManager

@Repository
class CardDAOImpl @Autowired
constructor(private val entityManager: EntityManager) : CardDAO {

    override fun findAll(): List<Card> {
        val currentSession = entityManager.unwrap(Session::class.java)
        val query = currentSession.createQuery("from Card", Card::class.java)
        return query.resultList
    }

    override fun findById(id: Int): Card? {
        val currentSession = entityManager.unwrap(Session::class.java)
        return currentSession.get(Card::class.java, id)
    }

    override fun save(card: Card) {
        val currentSession = entityManager.unwrap(Session::class.java)
        currentSession.saveOrUpdate(card)
    }

    override fun deleteById(id: Int) {
        val currentSession = entityManager.unwrap(Session::class.java)
        val query = currentSession.createQuery("delete from Card where id=:cardId")
        query.setParameter("cardId", id)
        query.executeUpdate()
    }
}
