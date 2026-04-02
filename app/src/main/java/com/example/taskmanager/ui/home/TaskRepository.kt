package com.example.taskmanager.ui.home

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TaskRepository @Inject constructor() {

    suspend fun getTasks(): List<Task> = withContext(Dispatchers.IO) {
        delay(3000)
        return@withContext MockDataProvider.getTasks()
    }
}