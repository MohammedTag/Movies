package com.task.domain.domain_module.country_listing.models

import com.task.domain.domain_module.packages_listing.models.Image

data class Operator(
    val activation_policy: String,
    val apn_single: String,
    val apn_type: String,
    val apn_type_android: String,
    val countries: List<Country>,
    val data_roaming: Boolean,
    val gradient_end: String,
    val gradient_start: String,
    val id: Int,
    val image: Image,
    val info: List<String>,
    val is_kyc_verify: Int,
    val is_multi_package: Boolean,
    val is_prepaid: Boolean,
    val networks: List<Network>,
    val plan_type: String,
    val rechargeability: Boolean,
    val style: String,
    val title: String,
    val type: String
)