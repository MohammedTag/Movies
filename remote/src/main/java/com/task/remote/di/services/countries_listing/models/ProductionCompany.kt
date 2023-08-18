package com.task.remote.di.services.countries_listing.models

import com.task.domain.domain_module.packages_listing.models.ProductionCompanyDomain

data class ProductionCompany(
    val id: Int,
    val logo_path: String?,
    val name: String,
    val origin_country: String
){
    fun toDomain()=ProductionCompanyDomain(id,logo_path, name, origin_country)
}