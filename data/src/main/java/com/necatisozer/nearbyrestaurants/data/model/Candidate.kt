package com.necatisozer.nearbyrestaurants.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Candidate(
    @SerialName("name")
    val name: String? = null,
    @SerialName("photos")
    val photos: List<Photo>? = null,
    @SerialName("place_id")
    val placeId: String? = null
)
