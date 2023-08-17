package com.task.airalo.ui_module.local_esims_listing.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.task.airalo.R
import com.task.domain.domain_module.country_listing.models.MoviesDomain
import com.task.domain.domain_module.country_listing.models.ResultDomain


class LocaleSimListingAdapter(private var actions: Action) : ListAdapter<ResultDomain, LocaleSimItemViewHolder>(
    LocaleSimListingDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocaleSimItemViewHolder {
        val viewHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return LocaleSimItemViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: LocaleSimItemViewHolder, position: Int) {
        holder.bind(getItem(position),actions)
    }
    class LocaleSimListingDiffCallback : DiffUtil.ItemCallback<ResultDomain>() {
        override fun areItemsTheSame(oldItem: ResultDomain, newItem: ResultDomain): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ResultDomain, newItem: ResultDomain): Boolean {
            return oldItem.id == newItem.id
        }

    }

    interface Action{
        fun onItemClicked(id:Int)
    }
}