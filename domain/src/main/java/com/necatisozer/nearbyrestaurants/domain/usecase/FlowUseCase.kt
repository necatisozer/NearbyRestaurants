package com.necatisozer.nearbyrestaurants.domain.usecase

import com.necatisozer.nearbyrestaurants.domain.model.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

abstract class FlowUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {
    operator fun invoke(parameters: P): Flow<Result<R>> = execute(parameters)
        .catch { e -> emit(Result.Error(Exception(e))) }
        .flowOn(coroutineDispatcher)

    protected abstract fun execute(parameters: P): Flow<Result<R>>
}
