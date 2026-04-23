package com.example.domain.model

sealed class Result<out D, out E> {
    data class Data<out D>(val data: D): Result<D, Nothing>()
    data class Error<out E>(val error: E): Result<Nothing, E>()
}