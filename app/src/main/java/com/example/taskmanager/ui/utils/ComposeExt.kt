package com.example.taskmanager.ui.utils

import androidx.compose.ui.Modifier

inline fun Modifier.applyIf(condition : Boolean, modifier : Modifier.() -> Modifier) : Modifier {
    return if (condition) {
        then(modifier(Modifier))
    } else {
        this
    }
}