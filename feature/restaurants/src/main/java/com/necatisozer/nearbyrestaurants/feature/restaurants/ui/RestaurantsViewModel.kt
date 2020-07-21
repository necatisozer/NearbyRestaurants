package com.necatisozer.nearbyrestaurants.feature.restaurants.ui

import android.location.Location
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.necatisozer.nearbyrestaurants.domain.extension.onError
import com.necatisozer.nearbyrestaurants.domain.extension.onLoading
import com.necatisozer.nearbyrestaurants.domain.extension.onSuccess
import com.necatisozer.nearbyrestaurants.domain.usecase.GetNearbyRestaurantsUseCase
import kotlinx.coroutines.flow.launchIn

class RestaurantsViewModel @ViewModelInject constructor(
    private val getNearbyRestaurantsUseCase: GetNearbyRestaurantsUseCase
) : ViewModel() {
    private val _liveData = MutableLiveData<String>()
    val liveData: LiveData<String> get() = _liveData

    fun getRestaurants(location: Location) {
        @Suppress("MagicNumber")
        getNearbyRestaurantsUseCase(location)
            .onLoading { _liveData.value = "Loading" }
            .onSuccess { restaurants ->
                _liveData.value = restaurants.joinToString("\n") { it.name }
            }
            .onError { _liveData.value = it.message }
            .launchIn(viewModelScope)
    }
}
