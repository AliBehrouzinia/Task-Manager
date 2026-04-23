package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.taskmanager.home.HomeViewModel
import com.example.taskmanager.home.ui.HomeRoute
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