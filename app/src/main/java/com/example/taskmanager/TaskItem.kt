package com.example.taskmanager

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TaskItem(modifier: Modifier, title: String) {
    var isSelected by remember { mutableStateOf(false) }


    Card(
        modifier = modifier.fillMaxWidth(), shape = RoundedCornerShape(12)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .applyIf(isSelected) {
                    drawBehind {
                        val canvasWidth = size.width
                        val canvasHeight = size.height
                        val margin = 12f
                        drawLine(
                            start = Offset(x = 0f + margin, y = canvasHeight / 2),
                            end = Offset(x = canvasWidth - margin, y = canvasHeight / 2),
                            color = Color.Gray
                        )
                    }
                }, verticalAlignment = Alignment.CenterVertically
        ) {
            CheckerCircle(
                isSelected = isSelected, onClick = { isSelected = !isSelected })
            Text(text = title)
        }
    }
}

@Composable
fun CheckerCircle(modifier: Modifier = Modifier, isSelected: Boolean, onClick: (() -> Unit)?) {
    RadioButton(
        modifier = modifier, selected = isSelected, onClick = onClick
    )
}

@Preview(widthDp = 150, backgroundColor = 0x000000, showBackground = true)
@Composable
fun TaskItemPreview() {
    Box(Modifier.background(Color.Yellow)) {
        TaskItem(Modifier, "task")
    }
}