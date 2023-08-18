package com.task.task.di.activity

import com.task.task.di.scope.ActivityScope
import com.task.task.ui_module.AppContentActivity
import com.task.task.ui_module.AppContentActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [AppContentActivityModule::class])
    abstract fun contributeAppContentActivityAndroidInjector(): AppContentActivity

}