package com.task.remote.di.services.countries_listing.models

import com.task.domain.domain_module.packages_listing.models.SpokenLanguageDomain

data class SpokenLanguage(
    val english_name: String,
    val iso_639_1: String,
    val name: String
){
    fun toDomain()=SpokenLanguageDomain(english_name, iso_639_1, name)
}