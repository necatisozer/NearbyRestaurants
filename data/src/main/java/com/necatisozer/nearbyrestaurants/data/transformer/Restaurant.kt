package com.necatisozer.nearbyrestaurants.data.transformer

import com.necatisozer.nearbyrestaurants.core.extension.illegalArg
import com.necatisozer.nearbyrestaurants.data.model.Result
import com.necatisozer.nearbyrestaurants.domain.model.PhotoId
import com.necatisozer.nearbyrestaurants.domain.model.Restaurant

fun Result.asRestaurant(): Restaurant {
    return Restaurant(
        id = placeId?.takeIf { it.isNotBlank() }
            ?: illegalArg("`placeId` cannot be null or blank"),
        name = name.orEmpty(),
        photos = photos?.asSequence()
            ?.mapNotNull { it.photoReference }
            ?.map { PhotoId(it) }
            ?.toList().orEmpty()
    )
}
