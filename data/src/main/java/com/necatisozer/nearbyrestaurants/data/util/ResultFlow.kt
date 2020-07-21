package com.necatisozer.nearbyrestaurants.data.util

import com.necatisozer.nearbyrestaurants.domain.model.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@Suppress("TooGenericExceptionCaught")
inline fun <T> resultFlow(crossinline call: suspend () -> T): Flow<Result<T>> {
    return flow {
        emit(Result.Loading)
        try {
            emit(Result.Success(call()))
        } catch (exception: Exception) {
            emit(Result.Error(exception))
        }
    }
}
