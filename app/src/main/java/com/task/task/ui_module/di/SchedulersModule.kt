package com.task.task.ui_module.di

import com.task.domain.domain_module.qualifires.Background
import com.task.domain.domain_module.qualifires.Foreground
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

/**
 * Created by Mohammed Sayed Taguldeen on 29,November,2019
 * Cairo, Egypt.
 */
@Module
class SchedulersModule {

    @Provides
    @Singleton
    @Foreground
    fun providesForegroundScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    @Provides
    @Singleton
    @Background
    fun providesBackgroundScheduler(): Scheduler {
        return Schedulers.io()
    }
}