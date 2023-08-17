package com.task.domain.domain_module.packages_listing.repositories

import com.task.domain.domain_module.country_listing.models.MoviesDomain
import com.task.domain.domain_module.packages_listing.models.MovieDetailsDomain
import io.reactivex.Single

interface MoviesRepository {

    fun getAvailableMovies(): Single<MoviesDomain>

    fun getMovieDetails(id:String):Single<MovieDetailsDomain>
}