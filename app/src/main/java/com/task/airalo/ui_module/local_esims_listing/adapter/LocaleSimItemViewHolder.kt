package com.task.airalo.ui_module.local_esims_listing.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.task.domain.domain_module.packages_listing.models.LocalEsimsItem
import kotlinx.android.synthetic.main.item_layout.view.countryNameTv
import kotlinx.android.synthetic.main.item_layout.view.flagIv

class LocaleSimItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: LocalEsimsItem, action: LocaleSimListingAdapter.Action) {
        itemView.apply {
            with(item) {
                setOnClickListener {
                    action.onItemClicked(id)
                }
                flagIv.load(image.url)
                countryNameTv.text = title
            }
        }
    }
}