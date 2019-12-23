package com.plugga.backend.repository

import com.plugga.backend.entity.Card
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface CardRepository : PagingAndSortingRepository<Card, Int>
