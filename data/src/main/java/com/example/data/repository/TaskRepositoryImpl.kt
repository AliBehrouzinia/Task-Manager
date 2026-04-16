package com.example.data.repository

import com.example.data.network.NetworkService
import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(val networkService: NetworkService) : TaskRepository {

    override suspend fun getTasks(): List<Task> = withContext(Dispatchers.IO) {
        return@withContext networkService.getTasks().map { it.toDomain() }
    }
}