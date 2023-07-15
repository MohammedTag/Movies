package com.task.data.data_module.packages_listing

import com.task.domain.domain_module.country_listing.models.CountryPackages
import com.task.domain.domain_module.packages_listing.models.LocalEsims
import com.task.domain.domain_module.packages_listing.repositories.PackagesListingRepository
import com.task.remote.di.services.packges_listing.PackagesService
import io.reactivex.Single

class PackagesListingDataSource(
    private val airaloPackagesService: PackagesService
) : PackagesListingRepository {
    override fun getAvailablePackages(): Single<LocalEsims> {
        return airaloPackagesService
            .getLocalEsims()
            .map { respone ->
                LocalEsims(respone.mapIndexed { index, localEsimResponseItem -> localEsimResponseItem.toDomain() })
            }
    }

    override fun getAvailableCountryPackages(id: String): Single<CountryPackages> {
        return airaloPackagesService.getCountryPackages(id).map {response->
            response.toDomain()
        }
    }
}