package com.natiqhaciyef.nikeapp.data.model

import androidx.lifecycle.MutableLiveData

sealed class ResponseResult<T> {
    data class Success<T> (val data : T): ResponseResult<Any?>()
    data class Error (val message: String): ResponseResult<Any?>()
    object Loading : ResponseResult<Any?>()
}

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): Resource<T & Any> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}
