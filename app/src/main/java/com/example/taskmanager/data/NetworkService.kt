package com.example.taskmanager.data

import com.example.taskmanager.data.model.TaskEntity
import retrofit2.http.GET


interface NetworkService {

    @GET("/Tasks.json")
    suspend fun getTasks(): List<TaskEntity>
}
