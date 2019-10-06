package com.plugga.backend.dao

import com.plugga.backend.entity.User
import javax.persistence.EntityManager
import org.hibernate.Session
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class UserDAOImpl @Autowired
constructor(private val entityManager: EntityManager) : UserDAO {

    override fun findAll(): MutableList<User> {
        val currentSession = entityManager.unwrap(Session::class.java)
        val query = currentSession.createQuery("from User", User::class.java)
        return query.resultList
    }

    override fun findById(id: Int): User? {
        val currentSession = entityManager.unwrap(Session::class.java)
        return currentSession.get(User::class.java, id)
    }

    override fun save(user: User) {
        val currentSession = entityManager.unwrap(Session::class.java)
        currentSession.saveOrUpdate(user)
    }

    override fun deleteById(id: Int) {
        val currentSession = entityManager.unwrap(Session::class.java)
        val query = currentSession.createQuery("delete from User where id=:userId")
        query.setParameter("userId", id)
        query.executeUpdate()
    }
}
