package com.example.taskmanager.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.taskmanager.presentation.home.ui.HomeRoute
import com.example.taskmanager.presentation.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope
        enableEdgeToEdge()
        setContent {
            val homeViewModel: HomeViewModel by viewModels()
            HomeRoute(
                homeViewModel = homeViewModel
            )
        }
    }
}