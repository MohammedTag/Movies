package com.task.domain.domain_module.packages_listing.use_cases

import com.task.domain.domain_module.abstract_usecases.SingleUseCase
import com.task.domain.domain_module.country_listing.models.MoviesDomain
import com.task.domain.domain_module.packages_listing.repositories.MoviesRepository
import com.task.domain.domain_module.qualifires.Background
import com.task.domain.domain_module.qualifires.Foreground
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

class GetAvailableMoviesUseCase @Inject constructor(
    private val repo: MoviesRepository,
    @Background private val backgroundScheduler: Scheduler,
    @Foreground private val foregroundScheduler: Scheduler
) : SingleUseCase<MoviesDomain, Unit>(
    backgroundScheduler,
    foregroundScheduler
) {

    override fun createSingle(input: Unit?): Single<MoviesDomain> {
        return repo.getAvailableMovies()
    }
}