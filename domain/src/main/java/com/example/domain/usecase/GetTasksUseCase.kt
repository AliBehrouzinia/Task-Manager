package com.example.domain.usecase

import com.example.domain.model.ErrorResult
import com.example.domain.model.Result
import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow


class GetTasksUseCase(
    private val taskRepository: TaskRepository
) {
    val tasks: Flow<Result<List<Task>, ErrorResult>> = taskRepository.getTasks()
}