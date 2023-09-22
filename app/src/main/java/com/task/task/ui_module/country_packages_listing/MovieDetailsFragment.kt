package com.task.task.ui_module.country_packages_listing

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
import com.task.domain.domain_module.packages_listing.models.MovieDetailsDomain
import com.task.task.R
import com.task.task.databinding.FragmentMovieDetailsBinding
import com.task.task.presentation_module.country_packages.MovieDetailsViewModel
import com.task.task.presentation_module.country_packages.models.MovieDetailsEvents
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MovieDetailsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MovieDetailsViewModel by viewModels { viewModelFactory }

    private val args: MovieDetailsFragmentArgs by navArgs()

    lateinit var binding: FragmentMovieDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding= FragmentMovieDetailsBinding.inflate(layoutInflater)
        return binding.root
    }
    private fun bindSuccessStateViews( movieDetailsDomain: MovieDetailsDomain) {
        binding.progressBar.visibility = GONE
        with(movieDetailsDomain) {
            binding.movieNameTv.text = title
            binding.productionYearTv.text = release_date

            genres.forEach{ genre ->
                binding.genresGroup.addView(createTagChip(requireContext(), genre.name))
            }
            binding.descriptionTv.text =overview
            binding.moviePosterIv.load("https://image.tmdb.org/t/p/w500/${poster_path}")
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
        binding.backIv.setOnClickListener {
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
                        binding.parentCl,
                        "${getString(R.string.something_went_wrong)}${event.err}",
                        Snackbar.LENGTH_SHORT
                    )
                        .show()
                }

                is MovieDetailsEvents.LoadingState -> {
                    binding.progressBar.visibility = VISIBLE
                }

                is MovieDetailsEvents.RetrievedretrievedMovieDetailsSuccessfully -> {
                    bindSuccessStateViews(event.movieDetailsDomain)
                }
            }
        })
    }
}