package com.example.taskmanager.presentation.home.ui

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
import com.example.taskmanager.presentation.home.HomeUiState
import com.example.taskmanager.presentation.home.model.UiTaskState
import com.example.taskmanager.presentation.theme.TaskManagerTheme

@Composable
fun HomeScreen(uiState: HomeUiState, onTaskClick: (Int) -> Unit) {
    TaskManagerTheme {
        Scaffold(modifier = Modifier.fillMaxSize(), content = { innerPadding ->
            val modifier = Modifier.padding(innerPadding)
            when (uiState) {
                is HomeUiState.Data -> DataState(modifier, uiState.data, onTaskClick)
                    HomeUiState.Empty -> EmptyState()
                HomeUiState.Error -> ErrorState()
                HomeUiState.Loading -> LoadingState()
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
fun DataState(modifier: Modifier, data: List<UiTaskState>, onTaskClick: (Int) -> Unit) {
    TaskList(modifier, data, onTaskClick)
}

@Composable
fun TaskList(modifier: Modifier, data: List<UiTaskState>, onTaskClick: (Int) -> Unit) {
    LazyColumn (modifier) {
        items(data) { item ->
            TaskItem(modifier, item, onTaskClick)
        }
    }

}
