package com.task.airalo.ui_module.country_packages_listing.adapter

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.task.domain.domain_module.packages_listing.models.MovieDetailsDomain
import kotlinx.android.synthetic.main.item_country_package.view.buyNowTv
import kotlinx.android.synthetic.main.item_country_package.view.cardViewGradientIv
import kotlinx.android.synthetic.main.item_country_package.view.dataAmountTv
import kotlinx.android.synthetic.main.item_country_package.view.packageCountryTv
import kotlinx.android.synthetic.main.item_country_package.view.packageImageIv
import kotlinx.android.synthetic.main.item_country_package.view.packageTitleTv
import kotlinx.android.synthetic.main.item_country_package.view.validityPeriodTv


class CountryPackageItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

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
