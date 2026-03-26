package com.example.taskmanager.ui.components

import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun CheckerCircle(modifier: Modifier = Modifier, isSelected: Boolean, onClick: (() -> Unit)?) {
    RadioButton(
        modifier = modifier,
        selected = isSelected,
        onClick = onClick,
        colors = RadioButtonDefaults.colors(selectedColor = Color.Gray)
    )
}
