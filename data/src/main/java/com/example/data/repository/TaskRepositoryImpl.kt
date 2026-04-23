package com.example.data.repository

import com.example.data.mapper.toDomain
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
        emit(Result.Data(networkService.getTasks().map { it.toDomain() }))
    }
}