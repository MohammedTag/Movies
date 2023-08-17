package com.task.airalo.ui_module.local_esims_listing.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.task.airalo.R
import com.task.domain.domain_module.country_listing.models.ResultDomain


class MoviesListingAdapter(private var actions: Action) : ListAdapter<ResultDomain, MovieItemViewHolder>(
    MoviesListingDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val viewHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MovieItemViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        holder.bind(getItem(position),actions)
    }
    class MoviesListingDiffCallback : DiffUtil.ItemCallback<ResultDomain>() {
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