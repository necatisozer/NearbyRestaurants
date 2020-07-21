package com.necatisozer.nearbyrestaurants.data.transformer

import com.necatisozer.nearbyrestaurants.domain.model.Location

fun Location.asString() = "$latitude,$longitude"