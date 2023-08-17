package com.task.airalo.presentation_module.country_packages.models

import com.task.domain.domain_module.packages_listing.models.MovieDetailsDomain

sealed class MovieDetailsEvents {
    object LoadingState : MovieDetailsEvents()

    class ErrorState(val err: Throwable) : MovieDetailsEvents()

    class RetrievedretrievedMovieDetailsSuccessfully(val movieDetailsDomain: MovieDetailsDomain) : MovieDetailsEvents()

    companion object {

        fun loading(): MovieDetailsEvents = LoadingState

        fun error(err: Throwable): MovieDetailsEvents =
            ErrorState(err)

        fun retrievedMovieDetailsSuccessfully(movieDetailsDomain: MovieDetailsDomain): MovieDetailsEvents =
            RetrievedretrievedMovieDetailsSuccessfully(movieDetailsDomain)

    }
}