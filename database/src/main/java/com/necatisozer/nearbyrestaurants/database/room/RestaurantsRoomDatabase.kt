package com.necatisozer.nearbyrestaurants.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.necatisozer.nearbyrestaurants.database.room.dao.RestaurantDao
import com.necatisozer.nearbyrestaurants.database.room.entity.Restaurant

@Database(
    entities = [Restaurant::class],
    version = 1,
    exportSchema = true
)
abstract class RestaurantsRoomDatabase : RoomDatabase() {

    abstract fun restaurantDao(): RestaurantDao

    companion object {
        const val NAME = "restaurants-db"
    }
}
