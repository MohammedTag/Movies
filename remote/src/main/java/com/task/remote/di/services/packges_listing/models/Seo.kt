package com.task.remote.di.services.packges_listing.models

import com.task.domain.domain_module.packages_listing.models.Image
import com.task.domain.domain_module.packages_listing.models.Seo

data class Seo(
    val description: Any,
    val keywords: Any,
    val title: Any
){
    fun toDomain(): Seo {
        return Seo(
           description, keywords, title
        )
    }
}