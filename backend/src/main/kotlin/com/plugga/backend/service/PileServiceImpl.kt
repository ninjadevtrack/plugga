package com.plugga.backend.service

import com.plugga.backend.dao.PileDAO
import com.plugga.backend.entity.Pile
import javax.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PileServiceImpl @Autowired
constructor(private val pileDAO: PileDAO) : PileService {

    @Transactional
    override fun findAll(): MutableList<Pile> {
        return pileDAO.findAll()
    }

    @Transactional
    override fun findById(id: Int): Pile? {
        return pileDAO.findById(id)
    }

    @Transactional
    override fun findByDeckId(id: Int): MutableList<Pile> {
        return pileDAO.findByDeckId(id)
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
