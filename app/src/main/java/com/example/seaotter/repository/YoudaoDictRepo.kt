package com.example.seaotter.repository

import com.example.seaotter.base.BaseRepository
import com.example.seaotter.http.RetrofitManager
import com.example.seaotter.http.api.YoudaoAPI
import com.example.seaotter.http.model.Response

/**
 * 有道词典
 */
class YoudaoDictRepo : BaseRepository() {

    val service by lazy { RetrofitManager.getService(YoudaoAPI::class.java, baseUrl = "https://dict.youdao.com") }

    /**
     * 获取有道每日一句
     */
    suspend fun getInfoLine(mode: String = "publish", date: String, update: String = "auto", apiVersion: String = "5.0"): Response<Map<Any, Any>> {
        return apiCall { service.getInfoLine(mode, date, update, apiVersion) }
    }
}