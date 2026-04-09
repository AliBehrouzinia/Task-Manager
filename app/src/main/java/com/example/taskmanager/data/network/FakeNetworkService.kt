package com.example.taskmanager.data.network

import com.example.taskmanager.data.model.TaskDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class FakeNetworkService : NetworkService {
    override suspend fun getTasks(): List<TaskDto> = withContext(Dispatchers.IO) {
        delay(2000)
        val tasks = mutableListOf<TaskDto>()
        tasks.add(TaskDto(1, "Do the dishes", false))
        tasks.add(TaskDto(2, "Do the laundry", false))
        tasks.add(TaskDto(3, "Pay the rent", true))

        return@withContext tasks
    }
}