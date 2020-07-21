package com.necatisozer.nearbyrestaurants.data.datasource

import com.necatisozer.nearbyrestaurants.data.api.PlacesApi
import com.necatisozer.nearbyrestaurants.domain.data.PhotoDataSource
import com.necatisozer.nearbyrestaurants.domain.extension.resultFlow
import com.necatisozer.nearbyrestaurants.domain.model.PhotoId
import com.necatisozer.nearbyrestaurants.domain.model.PhotoSize
import com.necatisozer.nearbyrestaurants.domain.model.PhotoUrl
import com.necatisozer.nearbyrestaurants.domain.model.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotoDataSourceImpl @Inject constructor(
    private val placesApi: PlacesApi
) : PhotoDataSource {
    override fun getPhotoUrl(
        photoId: PhotoId,
        maxWidth: PhotoSize?
    ): Flow<Result<PhotoUrl>> = resultFlow {
        val photoUrl = placesApi.getPhoto(
            photoReference = photoId.value,
            maxwidth = maxWidth?.value
        )
        return@resultFlow PhotoUrl(photoUrl)
    }
}
