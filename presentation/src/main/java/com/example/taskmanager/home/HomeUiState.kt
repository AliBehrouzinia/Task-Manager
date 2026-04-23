package com.example.taskmanager.home

import com.example.taskmanager.home.model.TaskUiState

sealed class HomeUiState {
    data class Data(val data: List<TaskUiState>): HomeUiState()
    object Loading: HomeUiState()
    object Error: HomeUiState()
    object Empty: HomeUiState()
}
