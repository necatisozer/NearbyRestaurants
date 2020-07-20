package com.necatisozer.nearbyrestaurants.nativelib

object ApiKeysProvider {

    external fun getPlacesApiKey(): String

    init {
        System.loadLibrary("api-keys")
    }
}
