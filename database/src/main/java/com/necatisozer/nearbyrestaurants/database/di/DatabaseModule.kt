package com.necatisozer.nearbyrestaurants.database.di

import com.necatisozer.nearbyrestaurants.database.database.RestaurantDatabaseImpl
import com.necatisozer.nearbyrestaurants.domain.data.RestaurantDatabase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
interface DatabaseModule {

    @get:Binds
    val RestaurantDatabaseImpl.restaurantDatabaseImpl: RestaurantDatabase

}
