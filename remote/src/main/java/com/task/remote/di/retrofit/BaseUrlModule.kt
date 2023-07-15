package com.task.remote.di.retrofit

import com.task.remote.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class BaseUrlModule {
    sealed class BaseUrl(val url: String) {
        class URL : BaseUrl(BuildConfig.BASE_URL)
    }

    @Provides
    @Singleton
    fun provideBaseUrl(): BaseUrl =
        BaseUrl.URL()
}