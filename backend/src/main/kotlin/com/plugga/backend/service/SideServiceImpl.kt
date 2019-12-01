package com.plugga.backend.service

import com.plugga.backend.dao.SideDAO
import com.plugga.backend.entity.Side
import java.util.Optional
import javax.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class SideServiceImpl @Autowired
constructor(private val sideDAO: SideDAO) : SideService {

    @Transactional
    override fun findAll(pageable: Pageable): Page<Side> {
        return sideDAO.findAll(pageable)
    }

    @Transactional
    override fun findById(id: Int): Side? {
        val queryResult: Optional<Side> = sideDAO.findById(id)
        return if (queryResult.isPresent) queryResult.get() else null
    }

    @Transactional
    override fun findByCardId(pageable: Pageable, cardId: Int): Page<Side> {
        return sideDAO.findByCardId(pageable, cardId)
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
