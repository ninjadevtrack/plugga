package com.plugga.backend.repository

import com.plugga.backend.entity.Deck
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface DeckRepository : PagingAndSortingRepository<Deck, Int>
