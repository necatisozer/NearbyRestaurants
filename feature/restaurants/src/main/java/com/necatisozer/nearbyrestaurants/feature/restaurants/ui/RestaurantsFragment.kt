package com.necatisozer.nearbyrestaurants.feature.restaurants.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.afollestad.assent.GrantResult
import com.afollestad.assent.Permission
import com.afollestad.assent.coroutines.awaitPermissionsResult
import com.afollestad.assent.rationale.createDialogRationale
import com.google.android.gms.location.LocationServices
import com.necatisozer.nearbyrestaurants.feature.restaurants.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_restaurants.*
import kotlinx.coroutines.tasks.await

@AndroidEntryPoint
class RestaurantsFragment : Fragment(R.layout.fragment_restaurants) {
    private val viewModel: RestaurantsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        toolbar.setupWithNavController(navController, appBarConfiguration)

        viewModel.liveData.observe(viewLifecycleOwner, textView::setText)

        requestLocation()
    }

    @SuppressLint("MissingPermission")
    private fun requestLocation() {
        val rationaleHandler = createDialogRationale(R.string.location_permission_rationale_title) {
            onPermission(
                Permission.ACCESS_FINE_LOCATION,
                R.string.location_permission_rationale_message
            )
        }

        @Suppress("TooGenericExceptionCaught")
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            val result = awaitPermissionsResult(
                Permission.ACCESS_FINE_LOCATION,
                rationaleHandler = rationaleHandler
            )

            if (result[Permission.ACCESS_FINE_LOCATION] != GrantResult.GRANTED) {
                textView.setText(R.string.error_location_permission)
                return@launchWhenStarted
            }

            val fusedLocationClient =
                LocationServices.getFusedLocationProviderClient(requireActivity())

            try {
                val location = fusedLocationClient.lastLocation.await()
                viewModel.getRestaurants(location)
            } catch (exception: Exception) {
                textView.setText(R.string.error_location_fetch)
            }
        }
    }
}
