package com.task.data.data_module

import com.task.data.data_module.packages_listing.MoviesDataSource
import com.task.domain.domain_module.packages_listing.repositories.MoviesRepository
import com.task.remote.di.retrofit.service.ServicesModule
import com.task.remote.di.services.listing.TheMoviesService
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
        airaloPackagesService: TheMoviesService
    ): MoviesRepository =
        MoviesDataSource(
            airaloPackagesService
        )


}