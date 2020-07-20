package com.necatisozer.nearbyrestaurants.data

import com.necatisozer.nearbyrestaurants.data.model.PlacesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PlacesApi {

    @GET("findplacefromtext")
    suspend fun findPlaceFromText(
        @Query("input") input: String,
        @Query("inputtype") inputtype: String = "textquery",
        @Query("fields") fields: String = "name,photos"
    ): PlacesResponse
}
