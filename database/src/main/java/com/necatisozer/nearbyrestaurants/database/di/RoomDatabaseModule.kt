package com.faskn.persistence.di

import android.content.Context
import androidx.room.Room
import com.necatisozer.nearbyrestaurants.database.room.RestaurantsRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RoomDatabaseModule {

    @Provides
    @Singleton
    internal fun provideRestaurantsDatabase(@ApplicationContext context: Context): RestaurantsRoomDatabase {
        return Room
            .databaseBuilder(context, RestaurantsRoomDatabase::class.java, RestaurantsRoomDatabase.NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    internal fun provideNearbySearchDao(database: RestaurantsRoomDatabase) = database.restaurantDao()
}
