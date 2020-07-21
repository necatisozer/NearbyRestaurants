package com.necatisozer.nearbyrestaurants.data.util

import com.necatisozer.nearbyrestaurants.nativelib.PlacesApiKey
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RequestInterceptor @Inject constructor(
    @PlacesApiKey private val apiKey: String
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val url = request.url
            .newBuilder()
            .addPathSegment("json")
            .addQueryParameter(PARAMETER_KEY, apiKey)
            .build()

        return chain.proceed(request.newBuilder().url(url).build())
    }

    companion object {
        private const val PARAMETER_KEY = "key"
    }
}
