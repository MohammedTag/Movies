package com.task.airalo.presentation_module.local_esims

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.task.airalo.di.ViewModelFactory
import com.task.airalo.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Mohammed Taguldeen on 13/07/2023.
 */
@Module
abstract class LocaleSimsViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(LocaleSimsViewModel::class)
    internal abstract fun bindLocaleSimsViewModel(localeSimsViewModel: LocaleSimsViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}