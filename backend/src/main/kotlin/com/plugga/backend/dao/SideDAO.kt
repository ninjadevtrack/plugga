package com.plugga.backend.dao

import com.plugga.backend.entity.Side
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface SideDAO : PagingAndSortingRepository<Side, Int> {

    fun findByCardId(cardId: Int): List<Side>

    fun findByCardId(pageable: Pageable, cardId: Int): Page<Side>
}
