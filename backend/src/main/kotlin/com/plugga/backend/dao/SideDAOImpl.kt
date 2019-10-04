package com.plugga.backend.dao

import com.plugga.backend.entity.Side
import org.hibernate.Session
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

import javax.persistence.EntityManager

@Repository
class SideDAOImpl @Autowired
constructor(private val entityManager: EntityManager) : SideDAO {

    override fun findAll(): MutableList<Side> {
        val currentSession = entityManager.unwrap(Session::class.java)
        val query = currentSession.createQuery("from Side", Side::class.java)
        return query.resultList
    }

    override fun findById(id: Int): Side? {
        val currentSession = entityManager.unwrap(Session::class.java)
        return currentSession.get(Side::class.java, id)
    }

    override fun findByCardId(cardId: Int): MutableList<Side> {
        val currentSession = entityManager.unwrap(Session::class.java)
        val query = currentSession.createQuery("from Side where card_id=:cardId", Side::class.java)
        query.setParameter("cardId", cardId)
        return query.resultList
    }

    override fun save(side: Side) {
        val currentSession = entityManager.unwrap(Session::class.java)
        currentSession.saveOrUpdate(side)
    }

    override fun deleteById(id: Int) {
        val currentSession = entityManager.unwrap(Session::class.java)
        val query = currentSession.createQuery("delete from Side where id=:sideId")
        query.setParameter("sideId", id)
        query.executeUpdate()
    }
}
