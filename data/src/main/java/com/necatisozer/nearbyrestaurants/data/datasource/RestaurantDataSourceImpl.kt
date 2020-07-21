package com.necatisozer.nearbyrestaurants.data.datasource

import com.necatisozer.nearbyrestaurants.data.api.PlacesApi
import com.necatisozer.nearbyrestaurants.data.transformer.asRestaurant
import com.necatisozer.nearbyrestaurants.data.transformer.asString
import com.necatisozer.nearbyrestaurants.data.util.resultFlow
import com.necatisozer.nearbyrestaurants.domain.data.RestaurantDataSource
import com.necatisozer.nearbyrestaurants.domain.model.Location
import com.necatisozer.nearbyrestaurants.domain.model.Radius
import com.necatisozer.nearbyrestaurants.domain.model.Restaurant
import com.necatisozer.nearbyrestaurants.domain.model.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RestaurantDataSourceImpl @Inject constructor(
    private val placesApi: PlacesApi
) : RestaurantDataSource {
    override fun getRestaurants(
        location: Location,
        radius: Radius
    ): Flow<Result<List<Restaurant>>> = resultFlow {
        val response =
            placesApi.searchNearbyPlaces(location.asString(), radius.value, TYPE_RESTAURANT)
        val restaurants = response.results?.map { it.asRestaurant() }
        return@resultFlow restaurants.orEmpty()
    }

    companion object {
        private const val TYPE_RESTAURANT = "restaurant"
    }
}
