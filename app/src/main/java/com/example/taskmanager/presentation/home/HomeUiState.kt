package com.example.taskmanager.presentation.home

import com.example.taskmanager.presentation.home.model.UiTaskState

sealed class HomeUiState {
    data class Data(val data: List<UiTaskState>): HomeUiState()
    object Loading: HomeUiState()
    object Error: HomeUiState()
    object Empty: HomeUiState()
}
