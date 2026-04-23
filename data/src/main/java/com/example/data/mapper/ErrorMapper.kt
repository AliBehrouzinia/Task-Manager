package com.example.data.mapper

import com.example.data.model.ErrorDto
import com.example.domain.model.ErrorResult

fun ErrorDto.toDomain(): ErrorResult = ErrorResult(
    code = this.code,
    message = this.message,
)
