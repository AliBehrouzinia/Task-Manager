package com.example.data.repository

import android.util.Log
import com.example.data.mapper.toDomain
import com.example.data.mapper.toDto
import com.example.domain.model.ErrorResult
import com.example.domain.model.Result
import com.example.data.network.NetworkService
import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(val networkService: NetworkService) : TaskRepository {

    override fun getTasks(): Flow<Result<List<Task>, ErrorResult>> = flow {
        networkService.getTasks().filterNotNull().map {
            it.toDomain()
        }.also {
            emit(Result.Data(it))
        }
    }

    override fun updateTask(task: Task): Flow<Result<Task, ErrorResult>> = flow {
        networkService.updateTask(task.id, task.toDto()).also {
            emit(Result.Data(it.toDomain()))
        }
    }
}