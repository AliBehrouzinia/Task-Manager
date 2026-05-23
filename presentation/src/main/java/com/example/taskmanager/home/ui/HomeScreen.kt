package com.example.taskmanager.home.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.taskmanager.home.HomeStatus
import com.example.taskmanager.home.HomeUiState
import com.example.taskmanager.home.model.TaskUiState
import com.example.taskmanager.theme.TaskManagerTheme

@Composable
fun HomeScreen(uiState: HomeUiState, onTaskClick: (TaskUiState) -> Unit) {
    TaskManagerTheme {
        Scaffold(modifier = Modifier.fillMaxSize(), content = { innerPadding ->
            val modifier = Modifier.padding(innerPadding)
            when (uiState.status) {
                HomeStatus.Content -> DataState(modifier, uiState.tasks, onTaskClick)
                HomeStatus.Empty -> EmptyState()
                HomeStatus.Loading -> LoadingState()
                is HomeStatus.Error -> ErrorState()
            }
        })
    }
}

@Composable
fun LoadingState() {
    IndeterminateCircularIndicator()
}

@Composable
fun IndeterminateCircularIndicator() {
    CircularProgressIndicator(
        modifier = Modifier.width(64.dp),
        color = MaterialTheme.colorScheme.secondary,
        trackColor = MaterialTheme.colorScheme.surfaceVariant,
    )
}

@Composable
fun ErrorState() {

}

@Composable
fun EmptyState() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text("No Tasks")
    }
}

@Composable
fun DataState(modifier: Modifier, data: List<TaskUiState>, onTaskClick: (TaskUiState) -> Unit) {
    TaskList(modifier, data, onTaskClick)
}

@Composable
fun TaskList(modifier: Modifier, data: List<TaskUiState>, onTaskClick: (TaskUiState) -> Unit) {
    LazyColumn(modifier) {
        items(data) { item ->
            TaskItem(modifier, item, { onTaskClick.invoke(item) })
        }
    }
}
