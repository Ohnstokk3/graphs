package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.test.ui.theme.TestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Test()

        }
    }
}

@Composable
fun Test() {        val textMeasurer = rememberTextMeasurer()
    Canvas(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxSize()
    ) {

        val canvasWidth = 0f
        val canvasHeight = 1700f

        val width = 200f
        val height = 500f
        val numRectangles = 3
        drawLine(
            start = Offset(x = canvasWidth, y = 0f),
            end = Offset(x = 0f, y = canvasHeight),
         strokeWidth = 3f,
            color = Color.Black

        )

        repeat(numRectangles) { index ->
            drawRect(
                color = Color.Red,
                size = Size(width, height),
                topLeft = Offset(80+ index *250f, 700f)/**so it 80+ from the left hand side of the app screen and each rectangle is space 250f*/,

                )
            drawText(textMeasurer, "Hello")

        }
    }
}
/*
@Composable
fun Test(data: List<Float>) {
    val canvasWidth = 0f
    val canvasHeight = 1700f

    val maxDataValue = data.maxOrNull() ?: 0f // Handle an empty list or list with 0 values
    val scale = canvasHeight / maxDataValue // Calculate scaling factor

    Canvas(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxSize()
    ) {

        val xAxisOffset = 80f // Adjust for desired x-axis position
        val barWidth = 50f // Adjust for desired bar width
        val barSpacing = 20f // Adjust for spacing between bars


        data.forEachIndexed { index, value ->
            val barHeight = value * scale // Calculate bar height based on data and scaling

            drawRect(
                color = Color.Red,
                size = Size(barWidth, barHeight),
                topLeft = Offset( x = xAxisOffset + index * (barWidth + barSpacing),y = canvasHeight - barHeight // Draw bars from top to bottom)
            )
        }
    }
}*/