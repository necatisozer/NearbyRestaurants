package com.necatisozer.nearbyrestaurants.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Review(
    @SerialName("author_name")
    val authorName: String? = null,
    @SerialName("author_url")
    val authorUrl: String? = null,
    @SerialName("language")
    val language: String? = null,
    @SerialName("profile_photo_url")
    val profilePhotoUrl: String? = null,
    @SerialName("rating")
    val rating: Int? = null,
    @SerialName("relative_time_description")
    val relativeTimeDescription: String? = null,
    @SerialName("text")
    val text: String? = null,
    @SerialName("time")
    val time: Int? = null
)
