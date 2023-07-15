package com.task.airalo.ui_module.local_esims_listing.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.task.airalo.R
import com.task.domain.domain_module.packages_listing.models.LocalEsimsItem


class LocaleSimListingAdapter(private var actions: Action) : ListAdapter<LocalEsimsItem, LocaleSimItemViewHolder>(
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
    class LocaleSimListingDiffCallback : DiffUtil.ItemCallback<LocalEsimsItem>() {
        override fun areItemsTheSame(oldItem: LocalEsimsItem, newItem: LocalEsimsItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: LocalEsimsItem, newItem: LocalEsimsItem): Boolean {
            return oldItem.id == newItem.id
        }

    }

    interface Action{
        fun onItemClicked(id:Int)
    }
}