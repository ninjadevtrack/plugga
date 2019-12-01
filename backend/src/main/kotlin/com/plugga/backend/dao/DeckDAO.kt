package com.plugga.backend.dao

import com.plugga.backend.entity.Deck
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface DeckDAO : PagingAndSortingRepository<Deck, Int>
