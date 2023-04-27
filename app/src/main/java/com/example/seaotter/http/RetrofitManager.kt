package com.example.seaotter.http

import com.example.seaotter.http.interceptor.logInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitManager {
    private const val TIME_OUT_SECONDS = 10

    private val client: OkHttpClient
        get() = OkHttpClient()
            .newBuilder()
            .addInterceptor(logInterceptor)
            .connectTimeout(TIME_OUT_SECONDS.toLong(), TimeUnit.SECONDS)
            .build()

    fun <T> getService(serviceClass: Class<T>, baseUrl: String?): T =
        Retrofit.Builder()
            .client(client)
            .baseUrl(baseUrl ?: "")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(serviceClass)
}