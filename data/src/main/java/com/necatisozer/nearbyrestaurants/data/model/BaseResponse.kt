package com.necatisozer.nearbyrestaurants.data.model

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    @SerialName("html_attributions")
    val htmlAttributions: List<@ContextualSerialization Any>? = null,
    @SerialName("result")
    val result: T? = null,
    @SerialName("status")
    val status: String? = null
)
