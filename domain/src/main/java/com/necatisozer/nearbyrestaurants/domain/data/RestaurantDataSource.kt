package com.necatisozer.nearbyrestaurants.domain.data

import com.necatisozer.nearbyrestaurants.domain.model.Location
import com.necatisozer.nearbyrestaurants.domain.model.Radius
import com.necatisozer.nearbyrestaurants.domain.model.Restaurant
import com.necatisozer.nearbyrestaurants.domain.model.RestaurantDetails
import com.necatisozer.nearbyrestaurants.domain.model.RestaurantId
import com.necatisozer.nearbyrestaurants.domain.model.Result
import kotlinx.coroutines.flow.Flow

interface RestaurantDataSource {
    fun getRestaurants(location: Location, radius: Radius): Flow<Result<List<Restaurant>>>
    fun getRestaurantDetails(restaurantId: RestaurantId): Flow<Result<RestaurantDetails>>
}
