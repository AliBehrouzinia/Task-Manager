package com.example.taskmanager.presentation.home.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.example.taskmanager.presentation.home.HomeViewModel

@Composable
fun HomeRoute(
    homeViewModel: HomeViewModel
) {
    val uiState by homeViewModel.uiState.collectAsState()
    HomeScreen(uiState, remember { homeViewModel::onTaskClick })
}