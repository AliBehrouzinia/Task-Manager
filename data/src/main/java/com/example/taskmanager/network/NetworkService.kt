package com.example.taskmanager.network

import com.example.taskmanager.model.TaskDto
import retrofit2.http.GET

interface NetworkService {

    @GET("/Tasks.json")
    suspend fun getTasks(): List<TaskDto>
}