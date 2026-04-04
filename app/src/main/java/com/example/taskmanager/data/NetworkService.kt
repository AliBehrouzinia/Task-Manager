package com.example.taskmanager.data

import android.telecom.Call
import com.example.taskmanager.data.model.Task
import retrofit2.http.GET


interface NetworkService {

    @GET
    suspend fun getTasks(): List<Task>
}
