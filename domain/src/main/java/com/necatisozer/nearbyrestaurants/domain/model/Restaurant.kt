package com.necatisozer.nearbyrestaurants.domain.model

data class Restaurant(
    val id: String,
    val name: String,
    val photos: List<PhotoId>
)
