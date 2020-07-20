package com.necatisozer.nearbyrestaurants.data.di

import android.content.Context
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.net.PlacesClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class PlacesClientModule {

    @Provides
    @ActivityScoped
    internal fun providePlacesClient(@ActivityContext context: Context): PlacesClient =
        Places.createClient(context)
}
