package com.plugga.backend.service

import com.plugga.backend.dao.PileDAO
import com.plugga.backend.entity.Pile
import java.util.Optional
import javax.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class PileServiceImpl @Autowired
constructor(private val pileDAO: PileDAO) : PileService {

    @Transactional
    override fun findAll(pageable: Pageable): Page<Pile> {
        return pileDAO.findAll(pageable)
    }

    @Transactional
    override fun findById(id: Int): Pile? {
        val queryResult: Optional<Pile> = pileDAO.findById(id)
        return if (queryResult.isPresent) queryResult.get() else null
    }

    @Transactional
    override fun findByDeckId(pageable: Pageable, id: Int): Page<Pile> {
        return pileDAO.findByDeckId(pageable, id)
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
