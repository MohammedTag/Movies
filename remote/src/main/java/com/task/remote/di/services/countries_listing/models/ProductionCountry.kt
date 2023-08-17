package com.task.remote.di.services.countries_listing.models

import com.task.domain.domain_module.packages_listing.models.ProductionCountryDomain

data class ProductionCountry(
    val iso_3166_1: String,
    val name: String
){
    fun toDomain()= ProductionCountryDomain(iso_3166_1,name)
}