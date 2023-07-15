package com.task.remote.di.device_info

import android.content.Context
import com.task.context.ContextModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(
    includes = [
        ContextModule::class
    ]
)
class HeadersModule {
    @Provides
    @Singleton
    fun providesHeaders(context: Context): Headers = Headers(context)

}