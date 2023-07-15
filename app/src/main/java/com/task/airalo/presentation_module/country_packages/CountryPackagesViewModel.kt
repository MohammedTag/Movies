package com.task.airalo.presentation_module.country_packages

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.task.airalo.presentation_module.BaseViewModel
import com.task.airalo.presentation_module.country_packages.models.CountryPackagesEvents
import com.task.domain.domain_module.country_listing.use_case.GetCountryPackagesUseCase
import io.reactivex.functions.Consumer
import javax.inject.Inject

/**
 * Created by Mohammed Taguldeen on 13/07/2023.
 */
class CountryPackagesViewModel @Inject constructor(
    private val getCountryPackagesUseCase: GetCountryPackagesUseCase
) : BaseViewModel() {

    private val _CountryPackagesListing = MutableLiveData<CountryPackagesEvents>()
    val countryPackagesListing: LiveData<CountryPackagesEvents>
        get() = _CountryPackagesListing



    fun getCountryPackagesListing(id:Int) {
        executeSingle(useCase =  getCountryPackagesUseCase.run(id.toString()),
            successConsumer = Consumer{ data->
                _CountryPackagesListing.value = CountryPackagesEvents.retrievedCountryPackagesListSuccessfully(data)
            },
            loadingConsumer = Consumer{
                _CountryPackagesListing.value = CountryPackagesEvents.loading()
            },
            throwableConsumer = Consumer{error->
                _CountryPackagesListing.value = CountryPackagesEvents.error(error)
            }
        )
    }
}