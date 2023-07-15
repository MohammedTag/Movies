package com.task.domain.domain_module.country_listing.models

import com.task.domain.domain_module.packages_listing.models.Image

data class Country(
    val id: Int,
    val image: Image,
    val slug: String,
    val title: String
)