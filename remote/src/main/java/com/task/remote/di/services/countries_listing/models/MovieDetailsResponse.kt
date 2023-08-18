package com.task.remote.di.services.countries_listing.models

import com.task.domain.domain_module.packages_listing.models.MovieDetailsDomain

data class MovieDetailsResponse(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: BelongsToCollection?,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<ProductionCompany>,
    val production_countries: List<ProductionCountry>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
) {
    fun toDomain() = MovieDetailsDomain(
        adult,
        backdrop_path,
        belongs_to_collection?.toDomain(),
        budget,
        genres.map { it.toDomain() },
        homepage,
        id,
        imdb_id,
        original_language,
        original_title,
        overview,
        popularity,
        poster_path,
        production_companies.map { it.toDomain() },
        production_countries.map { it.toDomain() },
        release_date,
        revenue,
        runtime,
        spoken_languages.map { it.toDomain() },
        status,
        tagline,
        title,
        video,
        vote_average,
        vote_count
    )
}