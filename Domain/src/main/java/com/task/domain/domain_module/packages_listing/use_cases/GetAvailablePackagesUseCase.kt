package com.task.domain.domain_module.packages_listing.use_cases

import com.task.domain.domain_module.abstract_usecases.SingleUseCase
import com.task.domain.domain_module.packages_listing.models.LocalEsims
import com.task.domain.domain_module.packages_listing.repositories.PackagesListingRepository
import com.task.domain.domain_module.qualifires.Background
import com.task.domain.domain_module.qualifires.Foreground
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

class GetAvailablePackagesUseCase @Inject constructor(
    private val repo: PackagesListingRepository,
    @Background private val backgroundScheduler: Scheduler,
    @Foreground private val foregroundScheduler: Scheduler
) : SingleUseCase<LocalEsims, Unit>(
    backgroundScheduler,
    foregroundScheduler
) {

    override fun createSingle(input: Unit?): Single<LocalEsims> {
        return repo.getAvailablePackages()
    }
}