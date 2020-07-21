package com.necatisozer.nearbyrestaurants.database.database

import com.necatisozer.nearbyrestaurants.database.room.dao.RestaurantDao
import com.necatisozer.nearbyrestaurants.database.transformer.asDatabaseRestaurant
import com.necatisozer.nearbyrestaurants.database.transformer.asDomainRestaurant
import com.necatisozer.nearbyrestaurants.domain.data.RestaurantDatabase
import com.necatisozer.nearbyrestaurants.domain.model.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton
import com.necatisozer.nearbyrestaurants.database.room.entity.Restaurant as DatabaseRestaurant
import com.necatisozer.nearbyrestaurants.domain.model.Restaurant as DomainRestaurant

@Singleton
class RestaurantDatabaseImpl @Inject constructor(
    private val restaurantDao: RestaurantDao
) : RestaurantDatabase {
    override val restaurants: Flow<Result<List<DomainRestaurant>>>
        get() = restaurantDao.getAll()
            .map<List<DatabaseRestaurant>, Result<List<DomainRestaurant>>> { restaurants ->
                val domainRestaurants = restaurants.map { it.asDomainRestaurant() }
                Result.Success(domainRestaurants)
            }

    override suspend fun saveRestaurants(restaurants: List<DomainRestaurant>) {
        val databaseRestaurants = restaurants.map { it.asDatabaseRestaurant() }
        restaurantDao.deleteAllAndInsert(databaseRestaurants)
    }
}