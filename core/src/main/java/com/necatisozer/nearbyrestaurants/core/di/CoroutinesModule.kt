package com.necatisozer.nearbyrestaurants.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

@InstallIn(ApplicationComponent::class)
@Module
object CoroutinesModule {

    @get:Provides
    @DefaultDispatcher
    internal val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default

    @get:Provides
    @IoDispatcher
    internal val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    @get:Provides
    @MainDispatcher
    internal val mainDispatcher: CoroutineDispatcher = Dispatchers.Main

    @get:Provides
    @MainImmediateDispatcher
    internal val mainImmediateDispatcher: CoroutineDispatcher = Dispatchers.Main.immediate
}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class DefaultDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IoDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class MainDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class MainImmediateDispatcher
