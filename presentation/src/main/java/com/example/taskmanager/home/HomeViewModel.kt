package com.example.taskmanager.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskmanager.home.mapper.toUiTaskState
import com.example.domain.model.Result
import com.example.domain.usecase.GetTasksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val getTasksUseCase: GetTasksUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getTasksUseCase.tasks.collect { result ->
                when (result) {
                    is Result.Error -> _uiState.emit(HomeUiState.Error)
                    is Result.Data -> _uiState.emit(HomeUiState.Data(result.data.map { it.toUiTaskState() }))
                }
            }
        }
    }

    fun onTaskClick(id: Int) {

    }
}