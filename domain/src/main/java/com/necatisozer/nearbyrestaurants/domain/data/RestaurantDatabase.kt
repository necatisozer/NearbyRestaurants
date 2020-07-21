package com.necatisozer.nearbyrestaurants.domain.data

import com.necatisozer.nearbyrestaurants.domain.model.Restaurant
import com.necatisozer.nearbyrestaurants.domain.model.Result
import kotlinx.coroutines.flow.Flow

interface RestaurantDatabase {
    val restaurants: Flow<Result<List<Restaurant>>>
    suspend fun saveRestaurants(restaurants: List<Restaurant>)
}
