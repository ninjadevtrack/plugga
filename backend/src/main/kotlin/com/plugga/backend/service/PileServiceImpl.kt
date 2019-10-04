package com.plugga.backend.service

import com.plugga.backend.dao.PileDAO
import com.plugga.backend.entity.Pile
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.transaction.Transactional

@Service
class PileServiceImpl @Autowired
constructor(private val pileDAO: PileDAO) : PileService {

    @Transactional
    override fun findAll(): List<Pile> {
        return pileDAO.findAll()
    }

    @Transactional
    override fun findById(id: Int): Pile {
        return pileDAO.findById(id)
    }

    @Transactional
    override fun save(pile: Pile) {
        pileDAO.save(pile)
    }

    @Transactional
    override fun deleteById(id: Int) {
        pileDAO.deleteById(id)
    }
}
