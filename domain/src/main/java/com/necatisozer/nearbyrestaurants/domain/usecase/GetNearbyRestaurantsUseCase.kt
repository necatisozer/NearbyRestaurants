package com.necatisozer.nearbyrestaurants.domain.usecase

import android.location.Location
import com.necatisozer.nearbyrestaurants.core.di.DefaultDispatcher
import com.necatisozer.nearbyrestaurants.domain.data.RestaurantDataSource
import com.necatisozer.nearbyrestaurants.domain.data.RestaurantDatabase
import com.necatisozer.nearbyrestaurants.domain.extension.flatMapConcatSuccess
import com.necatisozer.nearbyrestaurants.domain.extension.onSuccess
import com.necatisozer.nearbyrestaurants.domain.model.Radius
import com.necatisozer.nearbyrestaurants.domain.model.Restaurant
import com.necatisozer.nearbyrestaurants.domain.model.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNearbyRestaurantsUseCase @Inject constructor(
    private val restaurantDataSource: RestaurantDataSource,
    private val restaurantDatabase: RestaurantDatabase,
    @DefaultDispatcher defaultDispatcher: CoroutineDispatcher
) : FlowUseCase<Location, List<Restaurant>>(defaultDispatcher) {
    override fun execute(parameters: Location): Flow<Result<List<Restaurant>>> {
        return restaurantDataSource
            .getRestaurants(parameters, NEARBY_RADIUS_IN_METERS)
            .onSuccess(restaurantDatabase::saveRestaurants)
            .flatMapConcatSuccess { restaurantDatabase.restaurants }
    }

    companion object {
        private val NEARBY_RADIUS_IN_METERS = Radius(1_000)
    }
}
