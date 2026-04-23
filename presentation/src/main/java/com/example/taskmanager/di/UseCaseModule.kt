package com.example.taskmanager.di

import com.example.domain.repository.TaskRepository
import com.example.domain.usecase.GetTasksUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetTasksUseCase(taskRepository: TaskRepository): GetTasksUseCase {
        return GetTasksUseCase(taskRepository)
    }
}