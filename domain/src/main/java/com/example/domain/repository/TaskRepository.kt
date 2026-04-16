package com.example.domain.repository

import com.example.domain.model.Task

interface TaskRepository {
    suspend fun getTasks(): List<Task>
}