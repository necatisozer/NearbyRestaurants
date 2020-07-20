package com.necatisozer.nearbyrestaurants.data.model

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NearbyPlacesResponse(
    @SerialName("html_attributions")
    val htmlAttributions: List<@ContextualSerialization Any>? = null,
    @SerialName("next_page_token")
    val nextPageToken: String? = null,
    @SerialName("results")
    val results: List<Result>? = null,
    @SerialName("status")
    val status: String? = null
)
