package com.task.task.ui_module.di

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class App : Application(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    private fun initDagger(): Unit =
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    override fun androidInjector(): AndroidInjector<Any?> {
        return dispatchingAndroidInjector
    }

    companion object {
        var appIsRunning = false
        lateinit var application: App
    }
}