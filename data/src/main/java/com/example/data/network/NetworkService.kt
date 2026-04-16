package com.example.data.network

import com.example.data.model.TaskDto
import retrofit2.http.GET

interface NetworkService {

    @GET("/Tasks.json")
    suspend fun getTasks(): List<TaskDto>
}