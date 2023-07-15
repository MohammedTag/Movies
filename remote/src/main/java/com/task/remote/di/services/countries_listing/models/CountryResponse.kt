package com.task.remote.di.services.countries_listing.models

import com.task.domain.domain_module.country_listing.models.Country
import com.task.remote.di.services.packges_listing.models.ImageResponse

data class CountryResponse(
    val id: Int,
    val image: ImageResponse,
    val slug: String,
    val title: String
) {
    fun toDomain(): Country = Country(id, image.toDomain(), slug, title)
}