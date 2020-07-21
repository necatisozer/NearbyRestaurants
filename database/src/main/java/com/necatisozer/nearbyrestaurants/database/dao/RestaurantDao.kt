package com.necatisozer.nearbyrestaurants.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.necatisozer.nearbyrestaurants.database.entity.Restaurant
import kotlinx.coroutines.flow.Flow

@Dao
interface RestaurantDao {
    @Query("SELECT * FROM restaurant")
    fun getAll(): Flow<List<Restaurant>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(restaurants: List<Restaurant>)

    @Query("DELETE FROM restaurant")
    suspend fun deleteAll()

    @Transaction
    suspend fun deleteAllAndInsert(restaurants: List<Restaurant>) {
        deleteAll()
        insert(restaurants)
    }
}
