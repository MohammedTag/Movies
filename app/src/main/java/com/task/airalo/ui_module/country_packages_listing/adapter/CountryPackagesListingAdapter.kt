package com.task.airalo.ui_module.country_packages_listing.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.task.airalo.R
import com.task.domain.domain_module.country_listing.models.CountryPackages
import com.task.domain.domain_module.country_listing.models.Package
import com.task.domain.domain_module.packages_listing.models.LocalEsimsItem


class CountryPackagesListingAdapter : ListAdapter<Package, CountryPackageItemViewHolder>(
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
    class LocaleSimListingDiffCallback : DiffUtil.ItemCallback<Package>() {
        override fun areItemsTheSame(oldItem: Package, newItem: Package): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Package, newItem: Package): Boolean {
            return oldItem.id == newItem.id
        }

    }
}