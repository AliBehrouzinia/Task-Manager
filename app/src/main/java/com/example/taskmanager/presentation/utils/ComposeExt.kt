package com.example.taskmanager.presentation.utils

import androidx.compose.ui.Modifier

inline fun Modifier.applyIf(condition : Boolean, modifier : Modifier.() -> Modifier) : Modifier {
    return if (condition) {
        then(modifier(Modifier))
    } else {
        this
    }
}