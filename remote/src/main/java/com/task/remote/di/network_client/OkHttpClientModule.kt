package com.task.remote.di.network_client

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.task.context.BuildConfig
import com.task.context.ContextModule
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module(
    includes = [
        ContextModule::class
    ]
)
class OkHttpClientModule {

    @Provides
    @Singleton
    fun providesOkHttpClient(
        context: Context
    ): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor(context))
            .addInterceptor(HttpLoggingInterceptor().apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            })
        return okHttpClientBuilder.build()
    }
}