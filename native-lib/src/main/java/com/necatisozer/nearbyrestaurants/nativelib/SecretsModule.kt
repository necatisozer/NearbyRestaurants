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

    @Provides
    @Singleton
    @BaseUrl
    external fun getBaseUrl(): String

    init {
        System.loadLibrary("secrets")
    }
}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class PlacesApiKey

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class BaseUrl
