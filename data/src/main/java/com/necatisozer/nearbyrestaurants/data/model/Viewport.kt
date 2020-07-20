package com.necatisozer.nearbyrestaurants.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Viewport(
    @SerialName("northeast")
    val northeast: Northeast? = null,
    @SerialName("southwest")
    val southwest: Southwest? = null
)
