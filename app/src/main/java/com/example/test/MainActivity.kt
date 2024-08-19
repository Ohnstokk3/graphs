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
            test()

        }
    }
}
private val defaultMaxHeight = 200.dp

@Composable
fun test(){
    BarChart(values= listOf(20f,30f,40f,50f,15f,3f,10f,23f))
}

@Composable
fun BarChart(

    values: List<Float>,
    maxHeight: Dp = defaultMaxHeight
) {

    assert(values.isNotEmpty()) { "Input values are empty" }

    val borderColor = MaterialTheme.colorScheme.primary
    val density = LocalDensity.current
    val strokeWidth = with(density) { 1.dp.toPx() }

    Row(

        Modifier
            .fillMaxWidth()
            .height(maxHeight)
            .drawBehind {
                // draw X-Axis
                drawLine(
                    color = borderColor,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = strokeWidth
                )
                // draw Y-Axis
                drawLine(
                    color = borderColor,
                    start = Offset(0f, 0f),
                    end = Offset(0f, size.height),
                    strokeWidth = strokeWidth
                )
            }
        ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        values.forEach { item ->
            Bar(
                value = item,
                color = MaterialTheme.colorScheme.primary,
                maxHeight = maxHeight
            )
        }
    }

}

@Composable
private fun RowScope.Bar(
    value: Float,
    color: Color,
    maxHeight: Dp
) {

    val itemHeight = remember(value) { value * maxHeight.value / 100 }

    Spacer(
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .height(itemHeight.dp)
            .weight(1f)
            .background(color)
    )

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
/*@Composable
fun Test() {
Canvas(
modifier = Modifier
.padding(horizontal = 10.dp)
.fillMaxSize()
) {
val rectangleWidth = 200f
val rectangleHeight = 500f

// Draw 3 rectangles with spacing and customization options
val spacing = 50f
val numRectangles = 3
repeat(numRectangles) { index ->
val topLeftX = 0f + (index * (rectangleWidth + spacing))
val topLeftY = 700f - (index * spacing) // Adjust for desired Y positioning
drawRect(
color = Color(red = 255 - index * 50, green = 0, blue = 0), // Vary color for each rectangle
size = Size(rectangleWidth, rectangleHeight),
topLeft = Offset(topLeftX, topLeftY)
)
}
}
}*/
