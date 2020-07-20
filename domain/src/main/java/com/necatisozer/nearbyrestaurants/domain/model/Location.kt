package com.necatisozer.nearbyrestaurants.domain.model

import kotlin.math.PI
import kotlin.math.cos

data class Location(
    val latitude: Double,
    val longitude: Double
)

fun Location.shifted(dy: Long, dx: Long): Location {
    val newLatitude: Double = latitude + (dy / EARTH_RADIUS_IN_METERS).toDegree()
    val newLongitude: Double = longitude + (dx / EARTH_RADIUS_IN_METERS).toDegree() / cos(latitude)
    return Location(newLatitude, newLongitude)
}

fun Location.toBounds(distance: Long) = LocationBounds(
    southwest = shifted((-1) * distance, (-1) * distance),
    northeast = shifted(distance, distance)
)

@Suppress("MagicNumber")
fun Long.toDegree() = this * 180 / PI

private const val EARTH_RADIUS_IN_METERS = 6_378_137
