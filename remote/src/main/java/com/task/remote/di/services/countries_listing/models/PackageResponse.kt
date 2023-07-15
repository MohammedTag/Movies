package com.task.remote.di.services.countries_listing.models

import com.task.domain.domain_module.country_listing.models.Package

data class PackageResponse(
    val amount: Int,
    val data: String,
    val day: Int,
    val id: Int,
    val is_stock: Boolean,
    val is_unlimited: Boolean,
    val operator: OperatorResponse,
    val price: Double,
    val short_info: String?,
    val slug: String,
    val title: String,
    val type: String,
    val validity: String
) {
    fun toDomain(): Package = Package(
        amount = amount,
        data = data,
        day = day,
        id = id,
        is_stock = is_stock,
        is_unlimited = is_unlimited,
        operator = operator.toDomain(),
        price = price,
        short_info = short_info ?: "",
        slug = slug,
        title = title,
        type = type,
        validity = validity
    )
}