package com.necatisozer.nearbyrestaurants.domain.usecase

import com.necatisozer.nearbyrestaurants.core.di.DefaultDispatcher
import com.necatisozer.nearbyrestaurants.domain.data.RestaurantDataSource
import com.necatisozer.nearbyrestaurants.domain.model.Location
import com.necatisozer.nearbyrestaurants.domain.model.LocationBounds
import com.necatisozer.nearbyrestaurants.domain.model.Restaurant
import com.necatisozer.nearbyrestaurants.domain.model.Result
import com.necatisozer.nearbyrestaurants.domain.model.toBounds
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNearbyRestaurantsUseCase @Inject constructor(
    private val restaurantDataSource: RestaurantDataSource,
    @DefaultDispatcher defaultDispatcher: CoroutineDispatcher
) : FlowUseCase<Location, List<Restaurant>>(defaultDispatcher) {
    override fun execute(parameters: Location): Flow<Result<List<Restaurant>>> {
        val locationBounds: LocationBounds = parameters.toBounds(NEARBY_RADIUS_IN_METERS)
        return restaurantDataSource.getRestaurants(locationBounds)
    }

    companion object {
        private const val NEARBY_RADIUS_IN_METERS = 1_000L
    }
}
