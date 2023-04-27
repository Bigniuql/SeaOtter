package com.example.seaotter.http.api

import com.example.seaotter.http.model.Response
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query

interface YoudaoAPI {
    // example: https://dict.youdao.com/infoline?mode=publish&date=2023-04-26&update=auto&apiversion=5.0
    @FormUrlEncoded
    @GET("infoline")
    suspend fun getInfoLine(
        @Query("mode") mode: String,
        @Query("date") date: String,
        @Query("update") update: String,
        @Query("apiversion") apiversion: String,
    ): Response<Map<Any, Any>>
}