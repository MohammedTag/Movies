package com.task.remote.di.services.countries_listing.models

import com.task.domain.domain_module.country_listing.models.Network

data class NetworkResponse(
    val network: String,
    val service_type: String,
    val status: Boolean
) {
    fun toDomain(): Network = Network(network, service_type, status)
}