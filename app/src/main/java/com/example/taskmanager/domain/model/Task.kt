package com.example.taskmanager.domain.model

import com.example.taskmanager.presentation.home.model.UiTaskState

data class Task(
    val title: String, val id: Int, val isDone: Boolean
)

fun Task.toUiTaskState() : UiTaskState = UiTaskState(
    id = id,
    title = title,
    isDone = isDone
)