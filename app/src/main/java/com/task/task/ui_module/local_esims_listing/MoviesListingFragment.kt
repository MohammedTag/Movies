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
import com.task.task.presentation_module.local_esims.MoviesListViewModel
import com.task.task.presentation_module.local_esims.models.moviesListEvents
import com.task.task.ui_module.local_esims_listing.adapter.MoviesListingAdapter
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_movie_details.parentCl
import kotlinx.android.synthetic.main.fragment_movies_listing.emptyStateView
import kotlinx.android.synthetic.main.fragment_movies_listing.localeSimsRv
import kotlinx.android.synthetic.main.fragment_movies_listing.progressBar
import javax.inject.Inject

class MoviesListingFragment : DaggerFragment(), MoviesListingAdapter.Action {


    @Inject
    lateinit var localeSimsViewModelFactory: ViewModelProvider.Factory
    private val viewModel: MoviesListViewModel by viewModels { localeSimsViewModelFactory }

    private val adapter = MoviesListingAdapter(this)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_listing, container, false)
    }

    private fun bindViews() {
        localeSimsRv.adapter = adapter
    }

    private fun pullData() {
        with(viewModel) {
            getAvailablePackagesListing()
            availableMovies.observe(viewLifecycleOwner, Observer { event ->
                when (event) {
                    is moviesListEvents.ErrorState -> {
                        Snackbar.make(
                            parentCl,
                            "${getString(R.string.something_went_wrong)}${event.err}",
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }

                    is moviesListEvents.LoadingState -> {
                        progressBar.visibility = VISIBLE
                    }

                    is moviesListEvents.RetrievedMoviesListSuccessfully -> {
                        progressBar.visibility = GONE
                        with(event.moviesListing.results) {
                            if (isEmpty()) {
                                emptyStateView.visibility = VISIBLE
                            } else {
                                adapter.submitList(event.moviesListing.results)
                                emptyStateView.visibility = GONE
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