package com.task.remote.di.retrofit.service

import com.task.remote.di.retrofit.RetrofitModule
import com.task.remote.di.services.packges_listing.PackagesService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module(includes = [RetrofitModule::class])

class ServicesModule {

    @Provides
    @Singleton
    fun provideCallReasonsService(
        retrofit: Retrofit
    ): PackagesService {
        return retrofit.create(PackagesService::class.java)
    }
}