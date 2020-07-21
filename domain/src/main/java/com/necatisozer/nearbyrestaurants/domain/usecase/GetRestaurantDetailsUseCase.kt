package com.necatisozer.nearbyrestaurants.domain.usecase

import com.necatisozer.nearbyrestaurants.core.di.DefaultDispatcher
import com.necatisozer.nearbyrestaurants.domain.data.RestaurantDataSource
import com.necatisozer.nearbyrestaurants.domain.model.RestaurantDetails
import com.necatisozer.nearbyrestaurants.domain.model.RestaurantId
import com.necatisozer.nearbyrestaurants.domain.model.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRestaurantDetailsUseCase @Inject constructor(
    private val restaurantsDataSource: RestaurantDataSource,
    @DefaultDispatcher defaultDispatcher: CoroutineDispatcher
) : FlowUseCase<RestaurantId, RestaurantDetails>(defaultDispatcher) {
    override fun execute(parameters: RestaurantId): Flow<Result<RestaurantDetails>> {
        return restaurantsDataSource.getRestaurantDetails(parameters)
    }
}
