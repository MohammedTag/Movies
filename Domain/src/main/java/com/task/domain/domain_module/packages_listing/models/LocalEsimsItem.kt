package com.task.domain.domain_module.packages_listing.models

data class LocalEsimsItem(
    val id: Int,
    val image: Image,
    val package_count: Int,
    val slug: String,
    val title: String
)