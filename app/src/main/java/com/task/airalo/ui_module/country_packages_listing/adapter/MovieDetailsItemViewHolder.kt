package com.task.airalo.ui_module.country_packages_listing.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.task.domain.domain_module.packages_listing.models.MovieDetailsDomain


class MovieDetailsItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: MovieDetailsDomain) {
        itemView.apply {
            with(item) {
               /* packageImageIv.load(operator.image.url)
                packageTitleTv.text = operator.title
                packageCountryTv.text =
                    if (operator.countries.isNotEmpty()) operator.countries.first().title else ""
                val colors = intArrayOf(
                    Color.parseColor(operator.gradient_start),
                    Color.parseColor(operator.gradient_end)
                )
                val gd = GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT,
                    colors
                )
                cardViewGradientIv.background =gd
                dataAmountTv.text = data
                validityPeriodTv.text = validity
                buyNowTv.text = "US$${price} - BUY NOW"*/
            }
        }
    }
}
