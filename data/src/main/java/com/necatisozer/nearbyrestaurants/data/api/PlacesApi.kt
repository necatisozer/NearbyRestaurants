package com.necatisozer.nearbyrestaurants.data.api

import com.necatisozer.nearbyrestaurants.data.model.BaseListResponse
import com.necatisozer.nearbyrestaurants.data.model.BaseResponse
import com.necatisozer.nearbyrestaurants.data.model.Place
import com.necatisozer.nearbyrestaurants.data.model.PlaceDetails
import retrofit2.http.GET
import retrofit2.http.Query

interface PlacesApi {

    @GET("nearbysearch")
    suspend fun searchNearbyPlaces(
        @Query("location") location: String,
        @Query("radius") radius: Int,
        @Query("type") type: String? = null
    ): BaseListResponse<Place>

    @GET("photo")
    suspend fun getPhoto(
        @Query("photoreference") photoReference: String,
        @Query("maxheight") maxheight: Int? = null,
        @Query("maxwidth") maxwidth: Int? = null
    ): String

    @GET("details")
    suspend fun getDetails(
        @Query("place_id") placeId: String,
        @Query("fields") fields: String? = null
    ): BaseResponse<PlaceDetails>
}
