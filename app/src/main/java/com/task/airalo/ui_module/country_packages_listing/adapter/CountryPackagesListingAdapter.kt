package com.task.airalo.ui_module.country_packages_listing.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.task.airalo.R
import com.task.domain.domain_module.packages_listing.models.MovieDetailsDomain


class CountryPackagesListingAdapter : ListAdapter<MovieDetailsDomain, CountryPackageItemViewHolder>(
    LocaleSimListingDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryPackageItemViewHolder {
        val viewHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.item_country_package, parent, false)
        return CountryPackageItemViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: CountryPackageItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    class LocaleSimListingDiffCallback : DiffUtil.ItemCallback<MovieDetailsDomain>() {
        override fun areItemsTheSame(oldItem: MovieDetailsDomain, newItem: MovieDetailsDomain): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: MovieDetailsDomain, newItem: MovieDetailsDomain): Boolean {
            return oldItem.id == newItem.id
        }

    }
}