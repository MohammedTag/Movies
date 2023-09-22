package com.task.task.ui_module.local_esims_listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.task.task.R
import com.task.task.databinding.FragmentMoviesListingBinding
import com.task.task.presentation_module.local_esims.MoviesListViewModel
import com.task.task.presentation_module.local_esims.models.moviesListEvents
import com.task.task.ui_module.local_esims_listing.adapter.MoviesListingAdapter
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MoviesListingFragment : DaggerFragment(), MoviesListingAdapter.Action {


    @Inject
    lateinit var localeSimsViewModelFactory: ViewModelProvider.Factory
    private val viewModel: MoviesListViewModel by viewModels { localeSimsViewModelFactory }

    private val adapter = MoviesListingAdapter(this)

    private lateinit var binding: FragmentMoviesListingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMoviesListingBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun bindViews() {
        binding.localeSimsRv.adapter = adapter
    }

    private fun pullData() {
        with(viewModel) {
            getAvailablePackagesListing()
            availableMovies.observe(viewLifecycleOwner, Observer { event ->
                when (event) {
                    is moviesListEvents.ErrorState -> {
                        Snackbar.make(
                            binding.paretCl,
                            "${getString(R.string.something_went_wrong)}${event.err}",
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }

                    is moviesListEvents.LoadingState -> {
                        binding.progressBar.visibility = VISIBLE
                    }

                    is moviesListEvents.RetrievedMoviesListSuccessfully -> {
                        binding.progressBar.visibility = GONE
                        with(event.moviesListing.results) {
                            if (isEmpty()) {
                                binding.emptyStateView.visibility = VISIBLE
                            } else {
                                adapter.submitList(event.moviesListing.results)
                                binding.emptyStateView.visibility = GONE
                            }
                        }
                    }
                }
            })
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews()
        pullData()
    }

    override fun onItemClicked(id: Int) {
        findNavController().navigate(
            MoviesListingFragmentDirections.actionLocaleSimsListingFragmentToCountriesPackagesListingFragment(
                id
            )
        )
    }
}