package com.example.data.mapper

import com.example.domain.model.Task
import com.example.data.model.TaskDto

fun TaskDto.toDomain(): Task = Task(
    id = this.id,
    title = this.title,
    isDone = this.isDone,
)
