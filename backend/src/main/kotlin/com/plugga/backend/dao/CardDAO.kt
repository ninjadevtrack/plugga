package com.plugga.backend.dao

import com.plugga.backend.entity.Card
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface CardDAO : PagingAndSortingRepository<Card, Int>
