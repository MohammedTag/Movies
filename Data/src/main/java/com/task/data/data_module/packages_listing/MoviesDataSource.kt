package com.task.data.data_module.packages_listing

import com.task.domain.domain_module.country_listing.models.MoviesDomain
import com.task.domain.domain_module.packages_listing.models.MovieDetailsDomain
import com.task.domain.domain_module.packages_listing.repositories.MoviesRepository
import com.task.remote.di.services.EndPoints
import com.task.remote.di.services.listing.TheMoviesService
import io.reactivex.Single

class MoviesDataSource(
    private val service: TheMoviesService
) : MoviesRepository {
    override fun getAvailableMovies(): Single<MoviesDomain> {
        return service.getAvailableMovies().map { response ->
                response.toDomain()
            }
    }

    override fun getMovieDetails(id: String): Single<MovieDetailsDomain> {
        return service.getMovieDetails("https://api.themoviedb.org/3/movie/${id}").map { response ->
            response.toDomain()
        }
    }
}