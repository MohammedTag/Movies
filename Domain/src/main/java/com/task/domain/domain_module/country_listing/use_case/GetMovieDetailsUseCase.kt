package com.task.domain.domain_module.country_listing.use_case

import com.task.domain.domain_module.abstract_usecases.SingleUseCase
import com.task.domain.domain_module.packages_listing.models.MovieDetailsDomain
import com.task.domain.domain_module.packages_listing.repositories.MoviesRepository
import com.task.domain.domain_module.qualifires.Background
import com.task.domain.domain_module.qualifires.Foreground
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Mohammed Taguldeen on 13/07/2023.
 */
class GetMovieDetailsUseCase @Inject constructor(
    private val repo: MoviesRepository,
    @Background private val backgroundScheduler: Scheduler,
    @Foreground private val foregroundScheduler: Scheduler
) : SingleUseCase<MovieDetailsDomain, String>(
    backgroundScheduler,
    foregroundScheduler
) {

    override fun createSingle(input: String?): Single<MovieDetailsDomain> =
        if (input != null) {
            repo.getMovieDetails(input)
        } else {
            Single.error(IllegalArgumentException())
        }
}