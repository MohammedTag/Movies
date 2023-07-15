package com.task.airalo.presentation_module.country_packages

import androidx.lifecycle.ViewModel
import com.task.airalo.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class CountryPackagesViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CountryPackagesViewModel::class)
    internal abstract fun bindCountryPackagesViewModel(localeSimsViewModel: CountryPackagesViewModel): ViewModel

  /*  @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory*/
}