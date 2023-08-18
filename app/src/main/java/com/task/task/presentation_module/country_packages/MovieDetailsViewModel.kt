package com.task.task.presentation_module.country_packages

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.task.task.presentation_module.BaseViewModel
import com.task.task.presentation_module.country_packages.models.MovieDetailsEvents
import com.task.domain.domain_module.country_listing.use_case.GetMovieDetailsUseCase
import io.reactivex.functions.Consumer
import javax.inject.Inject

/**
 * Created by Mohammed Taguldeen on 13/07/2023.
 */
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase
) : BaseViewModel() {

    private val _MovieDetails = MutableLiveData<MovieDetailsEvents>()
    val movieDetails: LiveData<MovieDetailsEvents>
        get() = _MovieDetails



    fun getCountryPackagesListing(id:Int) {
        executeSingle(useCase =  getMovieDetailsUseCase.run(id.toString()),
            successConsumer = Consumer{ data->
                _MovieDetails.value = MovieDetailsEvents.retrievedMovieDetailsSuccessfully(data)
            },
            loadingConsumer = Consumer{
                _MovieDetails.value = MovieDetailsEvents.loading()
            },
            throwableConsumer = Consumer{error->
                _MovieDetails.value = MovieDetailsEvents.error(error)
            }
        )
    }
}