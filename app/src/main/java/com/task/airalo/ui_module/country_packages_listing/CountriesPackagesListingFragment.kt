package com.task.airalo.ui_module.country_packages_listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.task.airalo.R
import com.task.airalo.presentation_module.country_packages.CountryPackagesViewModel
import com.task.airalo.presentation_module.country_packages.models.CountryPackagesEvents
import com.task.airalo.ui_module.country_packages_listing.adapter.CountryPackagesListingAdapter
import com.task.domain.domain_module.country_listing.models.CountryPackages
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_countries_packages_listing.backIv
import kotlinx.android.synthetic.main.fragment_countries_packages_listing.countryNameTv
import kotlinx.android.synthetic.main.fragment_countries_packages_listing.countryPackagesRv
import kotlinx.android.synthetic.main.fragment_countries_packages_listing.emptyStateView
import kotlinx.android.synthetic.main.fragment_countries_packages_listing.parentCl
import kotlinx.android.synthetic.main.fragment_countries_packages_listing.progressBar
import javax.inject.Inject

class CountriesPackagesListingFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: CountryPackagesViewModel by viewModels { viewModelFactory }

    private val args: CountriesPackagesListingFragmentArgs by navArgs()
    private val adapter = CountryPackagesListingAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_countries_packages_listing, container, false)
    }

    private fun setupViews() {
        countryPackagesRv.adapter = adapter
        backIv.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun bindSuccessStateViews(countryPackages: CountryPackages) {
        progressBar.visibility = GONE
        with(countryPackages) {
            countryNameTv.text = title
            if (packages.isEmpty()) {
                emptyStateView.visibility = VISIBLE
            } else {
                if (emptyStateView.isVisible) emptyStateView.visibility = GONE
                adapter.submitList(packages)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCountryPackagesListing(args.id)
        setupViews()
        viewModel.countryPackagesListing.observe(viewLifecycleOwner, Observer { event ->
            when (event) {
                is CountryPackagesEvents.ErrorState -> {
                    Snackbar.make(
                        parentCl,
                        "${getString(R.string.something_went_wrong)}${event.err}",
                        Snackbar.LENGTH_SHORT
                    )
                        .show()
                }

                is CountryPackagesEvents.LoadingState -> {
                    progressBar.visibility = VISIBLE
                }

                is CountryPackagesEvents.RetrievedCountryPackagesListSuccessfully -> {
                    bindSuccessStateViews(event.countryPackages)
                }
            }
        })
    }
}