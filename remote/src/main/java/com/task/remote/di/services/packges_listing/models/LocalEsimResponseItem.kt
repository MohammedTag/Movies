package com.task.remote.di.services.packges_listing.models

import com.task.domain.domain_module.packages_listing.models.LocalEsimsItem

data class LocalEsimResponseItem(
    val id: Int,
    val image: ImageResponse,
    val package_count: Int,
    val slug: String,
    val title: String
) {
    fun toDomain(): LocalEsimsItem {
        return LocalEsimsItem(
            id, image.toDomain(), package_count, slug, title
        )
    }
}