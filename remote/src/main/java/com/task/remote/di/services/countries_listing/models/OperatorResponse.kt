package com.task.remote.di.services.countries_listing.models

import com.task.domain.domain_module.country_listing.models.Operator
import com.task.remote.di.services.packges_listing.models.ImageResponse

data class OperatorResponse(
    val activation_policy: String,
    val apn_single: String?,
    val apn_type: String,
    val apn_type_android: String,
    val countries: List<CountryResponse>,
    val data_roaming: Boolean,
    val gradient_end: String,
    val gradient_start: String,
    val id: Int,
    val image: ImageResponse,
//    val info: List<String>,
    val is_kyc_verify: Int,
    val is_multi_package: Boolean,
    val is_prepaid: Boolean,
    val networks: List<NetworkResponse>,
    val plan_type: String,
    val rechargeability: Boolean,
    val style: String,
    val title: String,
    val type: String
) {
    fun toDomain(): Operator = Operator(
        activation_policy = activation_policy,
        apn_single = apn_single ?:"",
        apn_type = apn_type,
        apn_type_android = apn_type_android,
        countries = countries.mapIndexed { index, countryResponse -> countryResponse.toDomain() },
        data_roaming = data_roaming,
        gradient_end = gradient_end,
        gradient_start = gradient_start,
        id = id,
        image = image.toDomain(),
        info = emptyList(),
        is_kyc_verify = is_kyc_verify,
        is_multi_package = is_multi_package,
        is_prepaid = is_prepaid,
        networks = networks.mapIndexed { index, networkResponse -> networkResponse.toDomain() },
        plan_type = plan_type,
        rechargeability = rechargeability,
        style = style,
        title = title,
        type = type
    )
}