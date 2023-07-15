package com.task.airalo.di.fragment

import com.task.airalo.di.scope.FragmentScope
import com.task.airalo.ui_module.country_packages_listing.CountriesPackagesListingFragment
import com.task.airalo.ui_module.local_esims_listing.LocaleSimsListingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsModule{
    @FragmentScope
    @ContributesAndroidInjector
    abstract  fun contributeLocaleSimsListingFragment(): LocaleSimsListingFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract  fun contributeCountriesPackagesListingFragment(): CountriesPackagesListingFragment
}