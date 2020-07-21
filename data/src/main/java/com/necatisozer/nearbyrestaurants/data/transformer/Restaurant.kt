package com.necatisozer.nearbyrestaurants.data.transformer

import com.necatisozer.nearbyrestaurants.core.extension.illegalArg
import com.necatisozer.nearbyrestaurants.data.model.Place
import com.necatisozer.nearbyrestaurants.domain.model.Restaurant

fun Place.asRestaurantDetails(): Restaurant {
    return Restaurant(
        id = placeId?.takeIf { it.isNotBlank() }
            ?: illegalArg("`placeId` cannot be null or blank"),
        name = name.orEmpty(),
        photoIds = photos?.mapNotNull { it.photoReference }.orEmpty()
    )
}
