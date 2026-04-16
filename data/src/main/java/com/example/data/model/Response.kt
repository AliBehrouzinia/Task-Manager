package com.example.data.model

class Response<D, E> (
    val status: String? = null,
    val message: String? = null,
    val error: E? = null,
    val data: D? = null
)
