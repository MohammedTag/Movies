package com.task.domain.domain_module.packages_listing.models

data class MovieDetailsDomain(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: BelongsToCollectionDomain,
    val budget: Int,
    val genres: List<GenreDomain>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<ProductionCompanyDomain>,
    val production_countries: List<ProductionCountryDomain>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguageDomain>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)