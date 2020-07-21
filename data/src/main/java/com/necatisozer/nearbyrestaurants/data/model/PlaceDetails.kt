package com.necatisozer.nearbyrestaurants.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlaceDetails(
    @SerialName("address_components")
    val addressComponents: List<AddressComponent>? = null,
    @SerialName("adr_address")
    val adrAddress: String? = null,
    @SerialName("formatted_address")
    val formattedAddress: String? = null,
    @SerialName("formatted_phone_number")
    val formattedPhoneNumber: String? = null,
    @SerialName("geometry")
    val geometry: Geometry? = null,
    @SerialName("icon")
    val icon: String? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("international_phone_number")
    val internationalPhoneNumber: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("place_id")
    val placeId: String? = null,
    @SerialName("rating")
    val rating: Double? = null,
    @SerialName("reference")
    val reference: String? = null,
    @SerialName("reviews")
    val reviews: List<Review>? = null,
    @SerialName("types")
    val types: List<String>? = null,
    @SerialName("url")
    val url: String? = null,
    @SerialName("utc_offset")
    val utcOffset: Int? = null,
    @SerialName("vicinity")
    val vicinity: String? = null,
    @SerialName("website")
    val website: String? = null
)
