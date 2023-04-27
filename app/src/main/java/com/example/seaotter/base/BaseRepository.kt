package com.example.seaotter.base

import com.example.seaotter.http.model.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class BaseRepository {

    suspend fun <T> apiCall(api: suspend () -> Response<T>): Response<T> {
        return withContext(Dispatchers.IO) { api.invoke() }
    }
}