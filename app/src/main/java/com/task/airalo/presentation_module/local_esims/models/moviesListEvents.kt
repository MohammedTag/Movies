package com.task.airalo.presentation_module.local_esims.models

import com.task.domain.domain_module.country_listing.models.MoviesDomain

/**
 * Created by Mohammed Taguldeen on 13/07/2023.
 */
sealed class moviesListEvents {
    object LoadingState : moviesListEvents()

    class ErrorState(val err: Throwable) : moviesListEvents()

    class RetrievedMoviesListSuccessfully(val moviesListing: MoviesDomain) : moviesListEvents()

    companion object {

        fun loading(): moviesListEvents = LoadingState

        fun error(err: Throwable): moviesListEvents =
            ErrorState(err)

        fun retrievedMoviesListSuccessfully(moviesListing: MoviesDomain): moviesListEvents =
            RetrievedMoviesListSuccessfully(moviesListing)

    }
}