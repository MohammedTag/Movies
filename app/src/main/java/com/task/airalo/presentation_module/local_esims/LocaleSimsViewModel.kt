package com.task.airalo.presentation_module.local_esims

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.task.airalo.presentation_module.BaseViewModel
import com.task.airalo.presentation_module.local_esims.models.LocaleSimsEvents
import com.task.airalo.presentation_module.local_esims.models.LocaleSimsEvents.*
import com.task.domain.domain_module.packages_listing.use_cases.GetAvailablePackagesUseCase
import io.reactivex.functions.Consumer
import javax.inject.Inject

/**
 * Created by Mohammed Taguldeen on 13/07/2023.
 */
class LocaleSimsViewModel @Inject constructor(
    private val getAvailablePackagesUseCase: GetAvailablePackagesUseCase
) : BaseViewModel(){

    private val _LocaleSimsListing = MutableLiveData<LocaleSimsEvents>()
    val localeSimsListing: LiveData<LocaleSimsEvents>
        get() = _LocaleSimsListing

    fun getAvailablePackagesListing() {
        executeSingle(useCase =  getAvailablePackagesUseCase.run(null),
            successConsumer = Consumer{data->
                _LocaleSimsListing.value = Companion.retrievedLocaleSimsListSuccessfully(data)
            },
            loadingConsumer = Consumer{
                _LocaleSimsListing.value = Companion.loading()
            },
            throwableConsumer = Consumer{error->
                _LocaleSimsListing.value = Companion.error(error)
            }
        )
    }
}