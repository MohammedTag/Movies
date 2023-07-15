package com.task.airalo.di.activity

import com.task.airalo.di.scope.ActivityScope
import com.task.airalo.ui_module.AppContentActivity
import com.task.airalo.ui_module.AppContentActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [AppContentActivityModule::class])
    abstract fun contributeAppContentActivityAndroidInjector(): AppContentActivity

}