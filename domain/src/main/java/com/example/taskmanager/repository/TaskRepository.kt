package com.example.taskmanager.repository

import com.example.taskmanager.model.Task

interface TaskRepository {
    suspend fun getTasks(): List<Task>
}