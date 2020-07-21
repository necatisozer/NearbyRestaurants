package com.necatisozer.nearbyrestaurants.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddressComponent(
    @SerialName("long_name")
    val longName: String? = null,
    @SerialName("short_name")
    val shortName: String? = null,
    @SerialName("types")
    val types: List<String>? = null
)
