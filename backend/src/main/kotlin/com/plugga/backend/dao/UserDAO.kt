package com.plugga.backend.dao

import com.plugga.backend.entity.User
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface UserDAO : PagingAndSortingRepository<User, Int>
