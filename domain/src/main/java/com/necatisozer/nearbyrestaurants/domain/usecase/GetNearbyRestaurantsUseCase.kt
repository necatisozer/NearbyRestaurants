package com.necatisozer.nearbyrestaurants.domain.usecase

import com.necatisozer.nearbyrestaurants.core.di.DefaultDispatcher
import com.necatisozer.nearbyrestaurants.domain.data.RestaurantDataSource
import com.necatisozer.nearbyrestaurants.domain.model.Location
import com.necatisozer.nearbyrestaurants.domain.model.Radius
import com.necatisozer.nearbyrestaurants.domain.model.Restaurant
import com.necatisozer.nearbyrestaurants.domain.model.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNearbyRestaurantsUseCase @Inject constructor(
    private val restaurantDataSource: RestaurantDataSource,
    @DefaultDispatcher defaultDispatcher: CoroutineDispatcher
) : FlowUseCase<Location, List<Restaurant>>(defaultDispatcher) {
    override fun execute(parameters: Location): Flow<Result<List<Restaurant>>> {
        return restaurantDataSource.getRestaurants(parameters, NEARBY_RADIUS_IN_METERS)
    }

    companion object {
        private val NEARBY_RADIUS_IN_METERS = Radius(1_000)
    }
}
