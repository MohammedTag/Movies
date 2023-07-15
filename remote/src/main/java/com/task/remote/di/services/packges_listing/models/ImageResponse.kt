package com.task.remote.di.services.packges_listing.models

import com.task.domain.domain_module.packages_listing.models.Image

data class ImageResponse(
    val height: Int, val url: String, val width: Int
) {
    fun toDomain(): Image {
        return Image(
            height, url, width
        )
    }
}