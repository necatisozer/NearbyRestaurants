package com.necatisozer.nearbyrestaurants.nativelib

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ApiKeysModule {

    @Provides
    @Singleton
    @PlacesApiKey
    external fun getPlacesApiKey(): String

    init {
        System.loadLibrary("api-keys")
    }
}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class PlacesApiKey
