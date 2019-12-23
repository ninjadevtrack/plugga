package com.plugga.backend.repository.util

import org.springframework.data.domain.Pageable

fun <T : Any> subListForRequestedPage(pageable: Pageable, list: MutableList<T>): MutableList<T> {

    val start = pageable.offset.toInt()
    val end = if (start + pageable.pageSize > list.size) list.size else start + pageable.pageSize

    return list.subList(start, end)
}
