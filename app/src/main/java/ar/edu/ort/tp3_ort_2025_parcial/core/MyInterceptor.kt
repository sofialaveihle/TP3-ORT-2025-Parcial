package ar.edu.ort.tp3_ort_2025_parcial.core

import okhttp3.Interceptor
import okhttp3.Response

object MyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val apiKey = Config.apiKey
        if (apiKey.isEmpty()) {
            throw IllegalStateException("API key is not set")
        }
        var request = chain.request()
        request = request.newBuilder()
            .header("X-Api-Key", apiKey ?: "")
            .header("Accept", "application/json")
            .header("Content-Type", "application/json")
            .build()
        return chain.proceed(request)
    }
}
