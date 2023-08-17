package com.task.airalo.ui_module.di

import android.app.Application
import com.task.context.ContextModule
import com.task.data.data_module.RepositoriesModule
import com.task.airalo.di.activity.ActivitiesModule
import com.task.airalo.di.fragment.FragmentsModule
import com.task.airalo.presentation_module.MappersModule
import com.task.airalo.presentation_module.country_packages.MovieDetailsViewModelModule
import com.task.airalo.presentation_module.local_esims.MoviesViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class, SchedulersModule::class, RepositoriesModule::class, ContextModule::class, MappersModule::class, ActivitiesModule::class, FragmentsModule::class, MoviesViewModelModule::class, MovieDetailsViewModelModule::class]
)
interface AppComponent {

    fun inject(application: App)

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }
}
