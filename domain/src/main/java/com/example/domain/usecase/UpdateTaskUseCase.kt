package com.example.domain.usecase

import com.example.domain.model.ErrorResult
import com.example.domain.model.Result
import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow


class UpdateTaskUseCase(
    private val taskRepository: TaskRepository
) {
    operator fun invoke(task: Task): Flow<Result<Task, ErrorResult>> = taskRepository.updateTask(task)
}