package com.example.seaotter.http.interceptor

import com.example.seaotter.utils.LogUtil
import okhttp3.logging.HttpLoggingInterceptor

val logInterceptor = HttpLoggingInterceptor(
    HttpLoggingInterceptor.Logger {
        LogUtil.d(it)
    }
)