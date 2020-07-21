package com.necatisozer.nearbyrestaurants.data.di

import com.necatisozer.nearbyrestaurants.data.datasource.PhotoDataSourceImpl
import com.necatisozer.nearbyrestaurants.data.datasource.RestaurantDataSourceImpl
import com.necatisozer.nearbyrestaurants.domain.data.PhotoDataSource
import com.necatisozer.nearbyrestaurants.domain.data.RestaurantDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
interface DataSourceModule {

    @get:Binds
    val RestaurantDataSourceImpl.restaurantDataSourceImpl: RestaurantDataSource

    @get:Binds
    val PhotoDataSourceImpl.photoDataSourceImpl: PhotoDataSource
}
