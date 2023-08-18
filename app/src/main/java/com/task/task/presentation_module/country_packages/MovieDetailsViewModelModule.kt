package com.task.task.presentation_module.country_packages

import androidx.lifecycle.ViewModel
import com.task.task.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class MovieDetailsViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailsViewModel::class)
    internal abstract fun bindMovieDetailsViewModel(movieDetailsViewModel: MovieDetailsViewModel): ViewModel
}