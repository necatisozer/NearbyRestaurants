package com.necatisozer.nearbyrestaurants.feature.restaurants.ui

import android.location.Location
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.necatisozer.nearbyrestaurants.core.extension.EMPTY
import com.necatisozer.nearbyrestaurants.domain.extension.onError
import com.necatisozer.nearbyrestaurants.domain.extension.onLoading
import com.necatisozer.nearbyrestaurants.domain.extension.onSuccess
import com.necatisozer.nearbyrestaurants.domain.usecase.GetNearbyRestaurantsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn

@Suppress("EXPERIMENTAL_API_USAGE")
class RestaurantsViewModel @ViewModelInject constructor(
    private val getNearbyRestaurantsUseCase: GetNearbyRestaurantsUseCase
) : ViewModel() {
    private val _stateFlow = MutableStateFlow(String.EMPTY)
    val liveData: StateFlow<String> get() = _stateFlow

    fun getRestaurants(location: Location) {
        getNearbyRestaurantsUseCase(location)
            .onLoading { _stateFlow.value = "Loading" }
            .onSuccess { restaurants ->
                _stateFlow.value = restaurants.joinToString("\n") { it.name }
            }
            .onError { _stateFlow.value = it.message ?: "An Error Occurred!" }
            .launchIn(viewModelScope)
    }
}
