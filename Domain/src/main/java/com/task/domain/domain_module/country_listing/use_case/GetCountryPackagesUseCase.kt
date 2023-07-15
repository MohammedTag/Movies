package com.task.domain.domain_module.country_listing.use_case

import com.task.domain.domain_module.abstract_usecases.SingleUseCase
import com.task.domain.domain_module.country_listing.models.CountryPackages
import com.task.domain.domain_module.packages_listing.repositories.PackagesListingRepository
import com.task.domain.domain_module.qualifires.Background
import com.task.domain.domain_module.qualifires.Foreground
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Mohammed Taguldeen on 13/07/2023.
 */
class GetCountryPackagesUseCase @Inject constructor(
    private val availablePackages: PackagesListingRepository,
    @Background private val backgroundScheduler: Scheduler,
    @Foreground private val foregroundScheduler: Scheduler
) : SingleUseCase<CountryPackages, String>(
    backgroundScheduler,
    foregroundScheduler
) {

    override fun createSingle(input: String?): Single<CountryPackages> =
        if (input != null) {
            availablePackages.getAvailableCountryPackages(input)
        } else {
            Single.error(IllegalArgumentException())
        }
}