package com.example.data.model

import com.example.domain.model.Task
import com.google.gson.annotations.SerializedName

data class TaskDto(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("isDone") val isDone: Boolean
) {
    fun toDomain(): Task = Task(
        id = this.id,
        title = this.title,
        isDone = this.isDone,
    )
}