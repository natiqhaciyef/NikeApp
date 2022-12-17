package com.natiqhaciyef.nikeapp.data.model

sealed class ResponseResult<T> {
    data class Success<T> (val data : T): ResponseResult<Any?>()
    data class Error (val message: String): ResponseResult<Any?>()
    object Loading : ResponseResult<Any?>()
}