package com.task.task.ui_module.local_esims_listing.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.task.domain.domain_module.country_listing.models.ResultDomain
import com.task.task.databinding.ItemLayoutBinding

class MovieItemViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ResultDomain, action: MoviesListingAdapter.Action) {
        itemView.apply {
            with(item) {
                setOnClickListener {
                    action.onItemClicked(id)
                }
                binding.flagIv.load("https://image.tmdb.org/t/p/w500/${poster_path}")
                binding.countryNameTv.text = title
            }
        }
    }
}