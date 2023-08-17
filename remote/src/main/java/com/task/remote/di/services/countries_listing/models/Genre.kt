package com.task.remote.di.services.countries_listing.models

import com.task.domain.domain_module.packages_listing.models.GenreDomain

data class Genre(
    val id: Int,
    val name: String
){
    fun toDomain()=GenreDomain(id, name)
}