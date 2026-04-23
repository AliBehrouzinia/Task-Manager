package com.example.data.model

import com.google.gson.annotations.SerializedName

data class TaskDto(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("isDone") val isDone: Boolean
)