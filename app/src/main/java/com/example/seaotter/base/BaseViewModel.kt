package com.example.seaotter.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    // 网络异常
    val exception = MutableLiveData<Exception>()

    // 服务报错
    val responseError = MutableLiveData<Exception>()

    abstract fun start()

}