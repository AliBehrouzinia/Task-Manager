package com.example.taskmanager.repository

import com.example.taskmanager.network.NetworkService
import com.example.taskmanager.model.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(val networkService: NetworkService) : TaskRepository {

    override suspend fun getTasks(): List<Task> = withContext(Dispatchers.IO) {
        return@withContext networkService.getTasks().map { it.toDomain() }
    }
}