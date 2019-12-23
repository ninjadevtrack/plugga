package com.plugga.backend.service

import com.plugga.backend.entity.Pile
import com.plugga.backend.repository.PileRepository
import java.util.Optional
import javax.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class PileServiceImpl @Autowired
constructor(private val pileRepository: PileRepository) : PileService {

    @Transactional
    override fun findAll(pageable: Pageable): Page<Pile> {
        return pileRepository.findAll(pageable)
    }

    @Transactional
    override fun findById(id: Int): Pile? {
        val queryResult: Optional<Pile> = pileRepository.findById(id)
        return if (queryResult.isPresent) queryResult.get() else null
    }

    @Transactional
    override fun findByDeckId(pageable: Pageable, id: Int): Page<Pile> {
        return pileRepository.findByDeckId(pageable, id)
    }

    @Transactional
    override fun save(pile: Pile) {
        pileRepository.save(pile)
    }

    @Transactional
    override fun deleteById(id: Int) {
        pileRepository.deleteById(id)
    }
}
