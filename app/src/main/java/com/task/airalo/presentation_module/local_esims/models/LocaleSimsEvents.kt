package com.task.airalo.presentation_module.local_esims.models

import com.task.domain.domain_module.packages_listing.models.LocalEsims

/**
 * Created by Mohammed Taguldeen on 13/07/2023.
 */
sealed class LocaleSimsEvents {
    object LoadingState : LocaleSimsEvents()

    class ErrorState(val err: Throwable) : LocaleSimsEvents()

    class RetrievedLocaleSimsListSuccessfully(val eSimsListing: LocalEsims) : LocaleSimsEvents()

    companion object {

        fun loading(): LocaleSimsEvents = LoadingState

        fun error(err: Throwable): LocaleSimsEvents =
            ErrorState(err)

        fun retrievedLocaleSimsListSuccessfully(eSimsListing: LocalEsims): LocaleSimsEvents =
            RetrievedLocaleSimsListSuccessfully(eSimsListing)

    }
}