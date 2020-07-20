package com.necatisozer.nearbyrestaurants.data.di

import android.content.Context
import androidx.startup.Initializer
import com.google.android.libraries.places.api.Places
import com.necatisozer.nearbyrestaurants.nativelib.ApiKeysProvider

class PlacesInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        val apiKey = ApiKeysProvider.getPlacesApiKey()
        Places.initialize(context, apiKey)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
