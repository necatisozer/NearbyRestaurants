package com.necatisozer.nearbyrestaurants.data.transformer

import com.necatisozer.nearbyrestaurants.core.extension.illegalArg
import com.necatisozer.nearbyrestaurants.data.model.PlaceDetails
import com.necatisozer.nearbyrestaurants.domain.model.RestaurantDetails

fun PlaceDetails.asRestaurantDetails(): RestaurantDetails {
    return RestaurantDetails(
        id = placeId?.takeIf { it.isNotBlank() }
            ?: illegalArg("`placeId` cannot be null or blank"),
        name = name.orEmpty()
    )
}
