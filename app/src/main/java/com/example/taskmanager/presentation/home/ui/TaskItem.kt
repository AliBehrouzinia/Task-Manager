package com.example.taskmanager.presentation.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.taskmanager.presentation.components.CheckerCircle
import com.example.taskmanager.presentation.home.model.UiTaskState
import com.example.taskmanager.presentation.utils.applyIf

@Composable
fun TaskItem(modifier: Modifier, uiTaskState: UiTaskState, onTaskClick: (Int) -> Unit) {
    val (isSelected, setSelected) = remember { mutableStateOf(uiTaskState.isDone) }
    val textColor = if (isSelected) Color.Gray else Color.Black

    Card(
        modifier = modifier.fillMaxWidth(), shape = RoundedCornerShape(12)
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CheckerCircle(
                isSelected = isSelected,
                onClick = {
                    setSelected(!isSelected)
                    onTaskClick(uiTaskState.id)
                }
            )
            Text(
                modifier = Modifier.applyIf(isSelected) {
                drawBehind {
                    val canvasWidth = size.width
                    val canvasHeight = size.height
                    drawLine(
                        start = Offset(x = 0f, y = canvasHeight / 2),
                        end = Offset(x = canvasWidth, y = canvasHeight / 2),
                        color = textColor,
                        strokeWidth = 2f
                    )
                }
            },
                text = uiTaskState.title,
                color = textColor
            )
        }
    }
}

@Preview(widthDp = 150, backgroundColor = 0x000000, showBackground = true)
@Composable
fun TaskItemPreview() {
    Box(Modifier.background(Color.Yellow)) {
        TaskItem(Modifier, UiTaskState("Task", 1, false), {})
    }
}