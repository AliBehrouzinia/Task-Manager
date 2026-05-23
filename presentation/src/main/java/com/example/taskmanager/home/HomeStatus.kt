package com.example.taskmanager.home

import com.example.domain.model.ErrorResult

sealed interface HomeStatus {
    object Loading : HomeStatus
    object Content : HomeStatus
    object Empty : HomeStatus
    data class Error(val error: ErrorResult) : HomeStatus
}