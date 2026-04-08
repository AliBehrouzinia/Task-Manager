package com.example.taskmanager.mapper

import com.example.taskmanager.data.model.TaskEntity
import com.example.taskmanager.ui.home.Task

fun TaskEntity.toPresentation(): Task {
    return Task(
        title = this.title,
        id = this.id,
        isDone = this.isDone,
    )
}