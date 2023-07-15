package com.task.remote.di.services.countries_listing.models

import com.task.domain.domain_module.country_listing.models.CountryPackages
import com.task.remote.di.services.packges_listing.models.ImageResponse


data class CountryPackagesResponse(
    val id: Int,
    val image: ImageResponse,
    val packages: List<PackageResponse>,
    val slug: String,
    val title: String
) {
    fun toDomain(): CountryPackages = CountryPackages(
        id,
        image.toDomain(),
        packages.mapIndexed { _, packageResponse -> packageResponse.toDomain() },

        slug,
        title
    )
}