package com.task.airalo.ui_module.country_packages_listing

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.google.android.material.chip.Chip
import com.google.android.material.snackbar.Snackbar
import com.task.airalo.R
import com.task.airalo.presentation_module.country_packages.MovieDetailsViewModel
import com.task.airalo.presentation_module.country_packages.models.MovieDetailsEvents
import com.task.domain.domain_module.packages_listing.models.MovieDetailsDomain
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_movie_details.backIv
import kotlinx.android.synthetic.main.fragment_movie_details.descriptionTv
import kotlinx.android.synthetic.main.fragment_movie_details.genresGroup
import kotlinx.android.synthetic.main.fragment_movie_details.movieNameTv
import kotlinx.android.synthetic.main.fragment_movie_details.moviePosterIv
import kotlinx.android.synthetic.main.fragment_movie_details.parentCl
import kotlinx.android.synthetic.main.fragment_movie_details.productionYearTv
import kotlinx.android.synthetic.main.fragment_movie_details.progressBar
import javax.inject.Inject

class MovieDetailsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MovieDetailsViewModel by viewModels { viewModelFactory }

    private val args: MovieDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }
    private fun bindSuccessStateViews( movieDetailsDomain: MovieDetailsDomain) {
        progressBar.visibility = GONE
        with(movieDetailsDomain) {
            movieNameTv.text = title
            productionYearTv.text = release_date

            genres.forEach{ genre ->
                genresGroup.addView(createTagChip(requireContext(), genre.name))
            }
            descriptionTv.text =overview
            moviePosterIv.load("https://image.tmdb.org/t/p/w500/${poster_path}")
        }
    }
    private fun createTagChip(context: Context, chipName: String): Chip {
        return Chip(context).apply {
            text = chipName
            setChipBackgroundColorResource(R.color.colorPrimary)
            setTextColor(ContextCompat.getColor(context, R.color.white))
//            setTextAppearance(R.style.ChipTextAppearance)
        }

    }
    private fun setupViews() {
        backIv.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCountryPackagesListing(args.id)
        setupViews()
        viewModel.movieDetails.observe(viewLifecycleOwner, Observer { event ->
            when (event) {
                is MovieDetailsEvents.ErrorState -> {
                    Snackbar.make(
                        parentCl,
                        "${getString(R.string.something_went_wrong)}${event.err}",
                        Snackbar.LENGTH_SHORT
                    )
                        .show()
                }

                is MovieDetailsEvents.LoadingState -> {
                    progressBar.visibility = VISIBLE
                }

                is MovieDetailsEvents.RetrievedretrievedMovieDetailsSuccessfully -> {
                    bindSuccessStateViews(event.movieDetailsDomain)
                }
            }
        })
    }
}