package com.plugga.backend.service

import com.plugga.backend.dao.SideDAO
import com.plugga.backend.entity.Side
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.transaction.Transactional

@Service
class SideServiceImpl @Autowired
constructor(private val sideDAO: SideDAO) : SideService {

    @Transactional
    override fun findAll(): MutableList<Side> {
        return sideDAO.findAll()
    }

    @Transactional
    override fun findById(id: Int): Side? {
        return sideDAO.findById(id)
    }

    @Transactional
    override fun findByCardId(cardId: Int): MutableList<Side> {
        return sideDAO.findByCardId(cardId)
    }

    @Transactional
    override fun save(side: Side) {
        sideDAO.save(side)
    }

    @Transactional
    override fun deleteById(id: Int) {
        sideDAO.deleteById(id)
    }
}
