package com.example.taskmanager.data.repository

import com.example.taskmanager.data.network.NetworkService
import com.example.taskmanager.presentation.home.model.UiTaskState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TaskRepository @Inject constructor(val networkService: NetworkService) {

    suspend fun getTasks(): List<UiTaskState> = withContext(Dispatchers.IO) {
        return@withContext networkService.getTasks().map { it.toPresentation() }
    }
}