package com.necatisozer.nearbyrestaurants.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlacesResponse(
    @SerialName("candidates")
    val candidates: List<Candidate>? = null,
    @SerialName("status")
    val status: String? = null
)
