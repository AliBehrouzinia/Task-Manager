package com.example.data.network

import com.example.data.model.TaskDto
import com.example.domain.model.Task
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface NetworkService {

    @GET("/Tasks.json")
    suspend fun getTasks(): List<TaskDto?>

    @PUT("/Tasks/{taskId}.json")
    suspend fun updateTask(
        @Path("taskId") taskId: Int,
        @Body task: TaskDto
    ): TaskDto
}