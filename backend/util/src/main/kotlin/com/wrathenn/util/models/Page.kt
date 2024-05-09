package com.wrathenn.util.models

data class Page<T>(
    val page: Int,
    val pageSize: Int,
    val totalElements: Int,
    val items: List<T>,
) {
    fun<A> map(f: (T) -> A): Page<A> = Page(
        page = page,
        pageSize = pageSize,
        totalElements = totalElements,
        items = items.map(f),
    )
}
