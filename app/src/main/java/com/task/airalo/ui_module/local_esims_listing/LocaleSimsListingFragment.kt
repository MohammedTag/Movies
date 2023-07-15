package com.task.airalo.ui_module.local_esims_listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.task.airalo.R
import com.task.airalo.presentation_module.local_esims.LocaleSimsViewModel
import com.task.airalo.presentation_module.local_esims.models.LocaleSimsEvents
import com.task.airalo.ui_module.local_esims_listing.adapter.LocaleSimListingAdapter
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_locale_sims_listing.localeSimsRv
import kotlinx.android.synthetic.main.fragment_locale_sims_listing.progressBar
import javax.inject.Inject

class LocaleSimsListingFragment : DaggerFragment(), LocaleSimListingAdapter.Action {


    @Inject
    lateinit var localeSimsViewModelFactory: ViewModelProvider.Factory
    private val viewModel: LocaleSimsViewModel by viewModels { localeSimsViewModelFactory }

    private val adapter = LocaleSimListingAdapter(this)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_locale_sims_listing, container, false)
    }

    private fun bindViews() {
        localeSimsRv.adapter=adapter
    }

    private fun pullData() {
        with(viewModel) {
            getAvailablePackagesListing()
            localeSimsListing.observe(viewLifecycleOwner) { event ->
                when (event) {
                    is LocaleSimsEvents.ErrorState -> {
                        val c = event.err
                        // TODO:  show error state
                    }

                    is LocaleSimsEvents.LoadingState -> {
                        // TODO: show loading state
                        progressBar.visibility = VISIBLE
                    }

                    is LocaleSimsEvents.RetrievedLocaleSimsListSuccessfully -> {
                        progressBar.visibility = GONE
                        with (event.eSimsListing.list){
                            if (isEmpty()) else adapter.submitList(event.eSimsListing.list)
                        }

//                        text.text = event.eSimsListing.toString()
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews()
        pullData()
    }

    override fun onItemClicked(id: Int) {
        // TODO: on click and navigate
        findNavController().navigate(LocaleSimsListingFragmentDirections.actionLocaleSimsListingFragmentToCountriesPackagesListingFragment(id))
    }
}