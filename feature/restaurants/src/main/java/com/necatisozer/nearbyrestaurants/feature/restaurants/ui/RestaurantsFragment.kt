package com.necatisozer.nearbyrestaurants.feature.restaurants.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.necatisozer.nearbyrestaurants.feature.restaurants.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_restaurants.*

@AndroidEntryPoint
class RestaurantsFragment : Fragment(R.layout.fragment_restaurants) {
    private val viewModel: RestaurantsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        toolbar.setupWithNavController(navController, appBarConfiguration)

        viewModel.liveData.observe(viewLifecycleOwner, textView::setText)
    }
}
