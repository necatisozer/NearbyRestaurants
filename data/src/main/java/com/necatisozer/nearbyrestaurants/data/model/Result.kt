package com.necatisozer.nearbyrestaurants.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    @SerialName("business_status")
    val businessStatus: String? = null,
    @SerialName("geometry")
    val geometry: Geometry? = null,
    @SerialName("icon")
    val icon: String? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("opening_hours")
    val openingHours: OpeningHours? = null,
    @SerialName("photos")
    val photos: List<Photo>? = null,
    @SerialName("place_id")
    val placeId: String? = null,
    @SerialName("plus_code")
    val plusCode: PlusCode? = null,
    @SerialName("price_level")
    val priceLevel: Int? = null,
    @SerialName("rating")
    val rating: Double? = null,
    @SerialName("reference")
    val reference: String? = null,
    @SerialName("scope")
    val scope: String? = null,
    @SerialName("types")
    val types: List<String>? = null,
    @SerialName("user_ratings_total")
    val userRatingsTotal: Int? = null,
    @SerialName("vicinity")
    val vicinity: String? = null
)
