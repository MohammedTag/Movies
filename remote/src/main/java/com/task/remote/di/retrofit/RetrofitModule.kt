package com.task.remote.di.retrofit

import com.squareup.moshi.Moshi
import com.task.remote.di.moshi.MoshiModule
import com.task.remote.di.network_client.OkHttpClientModule
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module(
    includes = [
        BaseUrlModule::class,
        OkHttpClientModule::class,
        MoshiModule::class
    ]
)
class RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        baseUrl: BaseUrlModule.BaseUrl,
        client: OkHttpClient,
        moshiParser: Moshi
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl.url)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshiParser))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
}