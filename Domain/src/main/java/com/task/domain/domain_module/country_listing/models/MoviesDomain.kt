package com.task.domain.domain_module.country_listing.models

data class MoviesDomain(
    val page: Int,
    val results: List<ResultDomain>,
    val total_pages: Int,
    val total_results: Int
)