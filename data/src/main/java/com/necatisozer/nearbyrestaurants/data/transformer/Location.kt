package com.necatisozer.nearbyrestaurants.data.transformer

import android.location.Location

fun Location.asString() = "$latitude,$longitude"
