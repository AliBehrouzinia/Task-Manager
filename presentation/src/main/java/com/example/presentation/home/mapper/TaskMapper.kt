package com.example.presentation.home.mapper

import com.example.domain.model.Task
import com.example.presentation.home.model.TaskUiState


fun Task.toUiTaskState(): TaskUiState = TaskUiState(
    id = this.id,
    title = this.title,
    isDone = this.isDone,
)
