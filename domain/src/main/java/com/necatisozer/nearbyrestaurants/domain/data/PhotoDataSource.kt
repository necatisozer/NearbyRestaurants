package com.necatisozer.nearbyrestaurants.domain.data

import com.necatisozer.nearbyrestaurants.domain.model.PhotoId
import com.necatisozer.nearbyrestaurants.domain.model.PhotoSize
import com.necatisozer.nearbyrestaurants.domain.model.PhotoUrl
import com.necatisozer.nearbyrestaurants.domain.model.Result
import kotlinx.coroutines.flow.Flow

interface PhotoDataSource {
    fun getPhotoUrl(photoId: PhotoId, maxWidth: PhotoSize? = null): Flow<Result<PhotoUrl>>
}
