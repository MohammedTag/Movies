package com.task.remote.di.moshi

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * after  agreeing with back-end team on a response , it should be specified in the
 * Moshi creation chain
 * **/

@Module
class MoshiModule {
    @Provides
    @Singleton
    fun providesMoshi(): Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
}
