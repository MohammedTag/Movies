package com.task.airalo.ui_module.local_esims_listing.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.task.domain.domain_module.country_listing.models.ResultDomain
import kotlinx.android.synthetic.main.item_layout.view.countryNameTv
import kotlinx.android.synthetic.main.item_layout.view.flagIv

class MovieItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: ResultDomain, action: MoviesListingAdapter.Action) {
        itemView.apply {
            with(item) {
                setOnClickListener {
                    action.onItemClicked(id)
                }
                flagIv.load(poster_path)
                countryNameTv.text = title
            }
        }
    }
}