package com.necatisozer.nearbyrestaurants.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Photo(
    @SerialName("height")
    val height: Int? = null,
    @SerialName("html_attributions")
    val htmlAttributions: List<String>? = null,
    @SerialName("photo_reference")
    val photoReference: String? = null,
    @SerialName("width")
    val width: Int? = null
)
