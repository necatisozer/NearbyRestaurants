package com.necatisozer.nearbyrestaurants.data.datasource

import com.necatisozer.nearbyrestaurants.core.extension.illegalArg
import com.necatisozer.nearbyrestaurants.data.api.PlacesApi
import com.necatisozer.nearbyrestaurants.data.transformer.asRestaurantDetails
import com.necatisozer.nearbyrestaurants.data.transformer.asString
import com.necatisozer.nearbyrestaurants.domain.data.RestaurantDataSource
import com.necatisozer.nearbyrestaurants.domain.extension.resultFlow
import com.necatisozer.nearbyrestaurants.domain.model.Location
import com.necatisozer.nearbyrestaurants.domain.model.Radius
import com.necatisozer.nearbyrestaurants.domain.model.Restaurant
import com.necatisozer.nearbyrestaurants.domain.model.RestaurantDetails
import com.necatisozer.nearbyrestaurants.domain.model.RestaurantId
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
        val restaurants = response.results?.map { it.asRestaurantDetails() }
        return@resultFlow restaurants.orEmpty()
    }

    override fun getRestaurantDetails(
        restaurantId: RestaurantId
    ): Flow<Result<RestaurantDetails>> = resultFlow {
        val response = placesApi.getDetails(restaurantId.value)
        return@resultFlow response.result?.asRestaurantDetails()
            ?: illegalArg("`result` cannot be null")
    }

    companion object {
        private const val TYPE_RESTAURANT = "restaurant"
    }
}
