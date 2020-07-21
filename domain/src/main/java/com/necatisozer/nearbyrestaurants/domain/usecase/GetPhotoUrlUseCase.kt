package com.necatisozer.nearbyrestaurants.domain.usecase

import com.necatisozer.nearbyrestaurants.core.di.DefaultDispatcher
import com.necatisozer.nearbyrestaurants.domain.data.PhotoDataSource
import com.necatisozer.nearbyrestaurants.domain.model.PhotoId
import com.necatisozer.nearbyrestaurants.domain.model.PhotoSize
import com.necatisozer.nearbyrestaurants.domain.model.PhotoUrl
import com.necatisozer.nearbyrestaurants.domain.model.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPhotoUrlUseCase @Inject constructor(
    private val photoDataSource: PhotoDataSource,
    @DefaultDispatcher defaultDispatcher: CoroutineDispatcher
) : FlowUseCase<PhotoId, PhotoUrl>(defaultDispatcher) {
    override fun execute(parameters: PhotoId): Flow<Result<PhotoUrl>> {
        return photoDataSource.getPhotoUrl(parameters, PHOTO_MAX_WIDTH)
    }

    companion object {
        private val PHOTO_MAX_WIDTH = PhotoSize(640)
    }
}
