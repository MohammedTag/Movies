package com.task.remote.di.services.countries_listing.models

import com.task.domain.domain_module.packages_listing.models.BelongsToCollectionDomain

data class BelongsToCollection(
    val backdrop_path: String,
    val id: Int,
    val name: String,
    val poster_path: String
){
    fun toDomain()=BelongsToCollectionDomain(backdrop_path, id, name, poster_path)
}