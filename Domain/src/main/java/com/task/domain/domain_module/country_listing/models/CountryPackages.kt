package com.task.domain.domain_module.country_listing.models

import com.task.domain.domain_module.packages_listing.models.Image

data class CountryPackages(
    val id: Int,
    val image: Image,
    val packages: List<Package>,
    val slug: String,
    val title: String
)