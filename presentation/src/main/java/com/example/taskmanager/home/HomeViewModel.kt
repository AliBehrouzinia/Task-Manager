package com.example.taskmanager.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskmanager.home.mapper.toUiTaskState
import com.example.domain.model.Result
import com.example.domain.usecase.GetTasksUseCase
import com.example.domain.usecase.UpdateTaskUseCase
import com.example.taskmanager.home.mapper.toDomain
import com.example.taskmanager.home.model.TaskUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.collections.map

@HiltViewModel
class HomeViewModel @Inject constructor(
    val getTasksUseCase: GetTasksUseCase, val updateTaskUseCase: UpdateTaskUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getTasksUseCase.tasks.collect { result ->
                when (result) {
                    is Result.Error -> _uiState.update { it.asError(result.error) }
                    is Result.Data -> _uiState.update {
                        it.asContent(result.data.map { task ->
                            task.toUiTaskState()
                        })
                    }
                }
            }
        }
    }

    fun onTaskClick(task: TaskUiState) {
        viewModelScope.launch {
            updateTaskUseCase(task = task.copy(isDone = !task.isDone).toDomain()).collect { result ->
                when (result) {
                    is Result.Error -> _uiState.update { it.asError(result.error) }
                    is Result.Data -> _uiState.update { uiState ->
                        uiState.asContent(uiState.tasks.map {
                            if (it.id == task.id) {
                                result.data.toUiTaskState()
                            } else {
                                it
                            }
                        })
                    }
                }
            }
        }
    }
}