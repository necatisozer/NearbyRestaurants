package com.necatisozer.nearbyrestaurants.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.necatisozer.nearbyrestaurants.database.dao.RestaurantDao
import com.necatisozer.nearbyrestaurants.database.entity.Restaurant

@Database(
    entities = [Restaurant::class],
    version = 1,
    exportSchema = true
)
abstract class RestaurantsDatabase : RoomDatabase() {

    abstract fun restaurantDao(): RestaurantDao

    companion object {
        const val NAME = "restaurants-db"
    }
}
