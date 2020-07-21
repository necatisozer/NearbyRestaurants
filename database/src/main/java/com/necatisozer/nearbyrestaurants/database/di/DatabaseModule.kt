package com.faskn.persistence.di

import android.content.Context
import androidx.room.Room
import com.necatisozer.nearbyrestaurants.database.db.RestaurantsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    internal fun provideRestaurantsDatabase(@ApplicationContext context: Context): RestaurantsDatabase {
        return Room
            .databaseBuilder(context, RestaurantsDatabase::class.java, RestaurantsDatabase.NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    internal fun provideNearbySearchDao(database: RestaurantsDatabase) = database.restaurantDao()
}
