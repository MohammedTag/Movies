package com.task.task.presentation_module.local_esims

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.task.task.presentation_module.BaseViewModel
import com.task.task.presentation_module.local_esims.models.moviesListEvents
import com.task.task.presentation_module.local_esims.models.moviesListEvents.*
import com.task.domain.domain_module.packages_listing.use_cases.GetAvailableMoviesUseCase
import io.reactivex.functions.Consumer
import javax.inject.Inject

/**
 * Created by Mohammed Taguldeen on 13/07/2023.
 */
class MoviesListViewModel @Inject constructor(
    private val getAvailableMoviesUseCaseUseCase: GetAvailableMoviesUseCase
) : BaseViewModel(){

    private val _AvailableMovies = MutableLiveData<moviesListEvents>()
    val availableMovies: LiveData<moviesListEvents>
        get() = _AvailableMovies

    fun getAvailablePackagesListing() {
        executeSingle(useCase =  getAvailableMoviesUseCaseUseCase.run(null),
            successConsumer = { data->
                _AvailableMovies.value = Companion.retrievedMoviesListSuccessfully(data)
            },
            loadingConsumer = {
                _AvailableMovies.value = Companion.loading()
            },
            throwableConsumer = { error->
                _AvailableMovies.value = Companion.error(error)
            }
        )
    }
}