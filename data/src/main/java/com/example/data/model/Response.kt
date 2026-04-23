package com.example.data.model

sealed class Response<D, E> {
    data class Data<D, E>(val data: D): Response<D, E>()
    data class Error<D, E>(val error: E): Response<D, E>()
}
