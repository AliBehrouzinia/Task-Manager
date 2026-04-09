package com.example.taskmanager.data.network

import com.example.taskmanager.data.model.TaskDto
import retrofit2.http.GET

interface NetworkService {

    @GET("/Tasks.json")
    suspend fun getTasks(): List<TaskDto>
}