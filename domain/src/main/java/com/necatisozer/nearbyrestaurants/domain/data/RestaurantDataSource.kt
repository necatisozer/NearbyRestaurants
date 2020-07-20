package com.necatisozer.nearbyrestaurants.domain.data

import com.necatisozer.nearbyrestaurants.domain.model.LocationBounds
import com.necatisozer.nearbyrestaurants.domain.model.Restaurant
import com.necatisozer.nearbyrestaurants.domain.model.Result
import kotlinx.coroutines.flow.Flow

interface RestaurantDataSource {
    fun getRestaurants(locationBounds: LocationBounds): Flow<Result<List<Restaurant>>>
}
