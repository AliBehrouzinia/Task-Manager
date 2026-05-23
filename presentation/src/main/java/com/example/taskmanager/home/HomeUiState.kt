package com.example.taskmanager.home

import com.example.domain.model.ErrorResult
import com.example.taskmanager.home.model.TaskUiState

data class HomeUiState(
    val tasks: List<TaskUiState> = emptyList(),
    val status: HomeStatus = HomeStatus.Loading
)

fun HomeUiState.asLoading(): HomeUiState =
    copy(status = HomeStatus.Loading)

fun HomeUiState.asContent(tasks: List<TaskUiState>): HomeUiState =
    copy(
        tasks = tasks,
        status = if (tasks.isEmpty()) HomeStatus.Empty else HomeStatus.Content
    )

fun HomeUiState.asError(error: ErrorResult): HomeUiState =
    copy(status = HomeStatus.Error(error))

fun HomeUiState.updateTask(updatedTask: TaskUiState): HomeUiState =
    copy(
        tasks = tasks.map { task ->
            if (task.id == updatedTask.id) updatedTask else task
        },
        status = HomeStatus.Content
    )