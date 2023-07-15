package com.task.data.data_module

import com.task.data.data_module.packages_listing.PackagesListingDataSource
import com.task.domain.domain_module.packages_listing.repositories.PackagesListingRepository
import com.task.remote.di.retrofit.service.ServicesModule
import com.task.remote.di.services.packges_listing.PackagesService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(
    includes = [
        // DoaModule::class,
        ServicesModule::class
    ]
)
class RepositoriesModule {


    @Provides
    @Singleton
    fun providesPackagesListingRepository(
        airaloPackagesService: PackagesService
    ): PackagesListingRepository =
        PackagesListingDataSource(
            airaloPackagesService
        )


}