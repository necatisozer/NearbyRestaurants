package com.necatisozer.nearbyrestaurants.database.transformer

import com.necatisozer.nearbyrestaurants.database.room.entity.Restaurant as DatabaseRestaurant
import com.necatisozer.nearbyrestaurants.domain.model.Restaurant as DomainRestaurant

fun DomainRestaurant.asDatabaseRestaurant() = DatabaseRestaurant(
    id = id,
    name = name,
    photoIds = photoIds?.joinToString(",")
)

fun DatabaseRestaurant.asDomainRestaurant() = DomainRestaurant(
    id = id,
    name = name,
    photoIds = photoIds?.split(",")
)
