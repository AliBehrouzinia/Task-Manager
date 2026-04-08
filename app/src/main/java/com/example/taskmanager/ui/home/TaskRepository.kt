package com.example.taskmanager.ui.home

import com.example.taskmanager.data.NetworkService
import com.example.taskmanager.mapper.toPresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TaskRepository @Inject constructor(val networkService: NetworkService) {

    suspend fun getTasks(): List<Task> = withContext(Dispatchers.IO) {
        return@withContext networkService.getTasks().map { it.toPresentation() }
    }
}