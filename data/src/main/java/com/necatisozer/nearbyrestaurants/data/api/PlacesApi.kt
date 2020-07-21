package com.necatisozer.nearbyrestaurants.data.api

import com.necatisozer.nearbyrestaurants.data.model.NearbyPlacesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PlacesApi {

    @GET("nearbysearch")
    suspend fun searchNearbyPlaces(
        @Query("location") location: String,
        @Query("radius") radius: Int,
        @Query("type") type: String? = null
    ): NearbyPlacesResponse
}