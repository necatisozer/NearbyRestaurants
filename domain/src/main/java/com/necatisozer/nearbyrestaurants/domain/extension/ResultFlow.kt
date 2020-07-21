package com.necatisozer.nearbyrestaurants.domain.extension

import com.necatisozer.nearbyrestaurants.domain.model.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach

@Suppress("TooGenericExceptionCaught")
fun <T> resultFlow(call: suspend () -> T): Flow<Result<T>> {
    return flow {
        emit(Result.Loading)
        try {
            emit(Result.Success(call()))
        } catch (exception: Exception) {
            emit(Result.Error(exception))
        }
    }
}

fun <T> Flow<Result<T>>.onSuccess(action: suspend (T) -> Unit): Flow<Result<T>> = onEach { result ->
    if (result is Result.Success) action(result.data)
}

fun <T> Flow<Result<T>>.onError(action: suspend (Exception) -> Unit): Flow<Result<T>> =
    onEach { result ->
        if (result is Result.Error) action(result.exception)
    }

fun <T> Flow<Result<T>>.onLoading(action: suspend () -> Unit): Flow<Result<T>> = onEach { result ->
    if (result is Result.Loading) action()
}

fun <T, R> Flow<Result<T>>.flatMapConcatSuccess(
    transform: suspend (value: Result.Success<T>) -> Flow<Result<R>>
): Flow<Result<R>> = flow {
    collect { result ->
        when (result) {
            is Result.Success -> emitAll(transform(result))
            is Result.Error -> emit(Result.Error(result.exception))
            is Result.Loading -> emit(Result.Loading)
        }
    }
}
