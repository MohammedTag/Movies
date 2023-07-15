package com.task.airalo.presentation_module.country_packages.models

import com.task.domain.domain_module.country_listing.models.CountryPackages

sealed class CountryPackagesEvents {
    object LoadingState : CountryPackagesEvents()

    class ErrorState(val err: Throwable) : CountryPackagesEvents()

    class RetrievedCountryPackagesListSuccessfully(val countryPackages: CountryPackages) : CountryPackagesEvents()

    companion object {

        fun loading(): CountryPackagesEvents = LoadingState

        fun error(err: Throwable): CountryPackagesEvents =
            ErrorState(err)

        fun retrievedCountryPackagesListSuccessfully(countryPackages: CountryPackages): CountryPackagesEvents =
            RetrievedCountryPackagesListSuccessfully(countryPackages)

    }
}