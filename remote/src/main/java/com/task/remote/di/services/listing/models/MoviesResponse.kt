package com.task.remote.di.services.listing.models

import com.task.domain.domain_module.country_listing.models.MoviesDomain

data class MoviesResponse(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
) {
    fun toDomain(): MoviesDomain =
        MoviesDomain(page, results.map { it.toDomain() }, total_pages, total_results)
}