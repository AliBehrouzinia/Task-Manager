package com.example.taskmanager.ui.home

sealed class HomeUiState {
    data class Data(val data: List<Task>): HomeUiState()
    object Loading: HomeUiState()
    object Error: HomeUiState()
    object Empty: HomeUiState()
}
