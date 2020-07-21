package com.necatisozer.nearbyrestaurants.core.extension

fun illegalArg(message: Any): Nothing = throw IllegalArgumentException(message.toString())
