package com.plugga.backend.dao

import com.plugga.backend.entity.DeckCard
import org.hibernate.Session
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

import javax.persistence.EntityManager

@Repository
class DeckCardDAOImpl @Autowired
constructor(private val entityManager: EntityManager) : DeckCardDAO {

    override fun findAll(): MutableList<DeckCard> {
        val currentSession = entityManager.unwrap(Session::class.java)
        val query = currentSession.createQuery("from DeckCard", DeckCard::class.java)
        return query.resultList
    }

    override fun findById(id: Int): DeckCard? {
        val currentSession = entityManager.unwrap(Session::class.java)
        return currentSession.get(DeckCard::class.java, id)
    }

    override fun findByDeckId(deckId: Int): MutableList<DeckCard> {
        val currentSession = entityManager.unwrap(Session::class.java)
        val query = currentSession.createQuery("from DeckCard where deck_id=:deckId", DeckCard::class.java)
        query.setParameter("deckId", deckId)
        return query.resultList
    }

    override fun findByCardId(cardId: Int): MutableList<DeckCard> {
        val currentSession = entityManager.unwrap(Session::class.java)
        val query = currentSession.createQuery("from DeckCard where card_id=:cardId", DeckCard::class.java)
        query.setParameter("cardId", cardId)
        return query.resultList
    }

    override fun save(deckCard: DeckCard) {
        val currentSession = entityManager.unwrap(Session::class.java)
        currentSession.saveOrUpdate(deckCard)
    }

    override fun deleteById(id: Int) {
        val currentSession = entityManager.unwrap(Session::class.java)
        val query = currentSession.createQuery("delete from DeckCard where id=:deckCardId")
        query.setParameter("deckCardId", id)
        query.executeUpdate()
    }
}
