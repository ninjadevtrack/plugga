package com.plugga.backend.dao

import com.plugga.backend.entity.Pile
import javax.persistence.EntityManager
import org.hibernate.Session
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class PileDAOImpl @Autowired
constructor(private val entityManager: EntityManager) : PileDAO {

    override fun findAll(): MutableList<Pile> {
        val currentSession = entityManager.unwrap(Session::class.java)
        val query = currentSession.createQuery("from Pile", Pile::class.java)
        return query.resultList
    }

    override fun findById(id: Int): Pile? {
        val currentSession = entityManager.unwrap(Session::class.java)
        return currentSession.get(Pile::class.java, id)
    }

    override fun findByDeckId(deckId: Int): MutableList<Pile> {
        val currentSession = entityManager.unwrap(Session::class.java)
        val query = currentSession.createQuery("from Pile where deck_id=:deckId", Pile::class.java)
        query.setParameter("deckId", deckId)
        return query.resultList
    }

    override fun save(pile: Pile) {
        val currentSession = entityManager.unwrap(Session::class.java)
        currentSession.saveOrUpdate(pile)
    }

    override fun deleteById(id: Int) {
        val currentSession = entityManager.unwrap(Session::class.java)
        val query = currentSession.createQuery("delete from Pile where id=:pileId")
        query.setParameter("pileId", id)
        query.executeUpdate()
    }
}
