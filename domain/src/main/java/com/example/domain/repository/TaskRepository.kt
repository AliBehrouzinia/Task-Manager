package com.example.domain.repository

import com.example.domain.model.ErrorResult
import com.example.domain.model.Result
import com.example.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getTasks(): Flow<Result<List<Task>, ErrorResult>>
}