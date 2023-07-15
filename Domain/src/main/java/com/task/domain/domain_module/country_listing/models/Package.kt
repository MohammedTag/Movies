package com.task.domain.domain_module.country_listing.models

data class Package(
    val amount: Int,
    val data: String,
    val day: Int,
    val id: Int,
    val is_stock: Boolean,
    val is_unlimited: Boolean,
    val operator: Operator,
    val price: Double,
    val short_info: String,
    val slug: String,
    val title: String,
    val type: String,
    val validity: String
)