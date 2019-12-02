package com.plugga.backend.service

import com.plugga.backend.repository.SideRepository
import com.plugga.backend.entity.Side
import java.util.Optional
import javax.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class SideServiceImpl @Autowired
constructor(private val sideRepository: SideRepository) : SideService {

    @Transactional
    override fun findAll(pageable: Pageable): Page<Side> {
        return sideRepository.findAll(pageable)
    }

    @Transactional
    override fun findById(id: Int): Side? {
        val queryResult: Optional<Side> = sideRepository.findById(id)
        return if (queryResult.isPresent) queryResult.get() else null
    }

    @Transactional
    override fun findByCardId(pageable: Pageable, cardId: Int): Page<Side> {
        return sideRepository.findByCardId(pageable, cardId)
    }

    @Transactional
    override fun save(side: Side) {
        sideRepository.save(side)
    }

    @Transactional
    override fun deleteById(id: Int) {
        sideRepository.deleteById(id)
    }
}
