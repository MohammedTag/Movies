package com.task.domain.domain_module.packages_listing.repositories

import com.task.domain.domain_module.country_listing.models.CountryPackages
import com.task.domain.domain_module.packages_listing.models.LocalEsims
import io.reactivex.Single

interface PackagesListingRepository {

    fun getAvailablePackages(): Single<LocalEsims>

    fun getAvailableCountryPackages(id:String):Single<CountryPackages>
}