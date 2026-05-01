package com.salamhack.presentation.shared.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salamhack.presentation.shared.designSystem.theme.Theme

@Composable
fun CircularProgressView(
    percentage: Int,
    modifier: Modifier = Modifier,
    size: Dp = 225.dp,
    strokeWidth: Dp = 10.dp,
    primaryColor: Color = Color(0xFF00449E),
    trackColor: Color = Color(0xFFE2E8F0),
    animationDuration: Int = 1000
) {
    var animationPlayed by remember { mutableStateOf(false) }

    val currentPercentage by animateFloatAsState(
        targetValue = if (animationPlayed) percentage.toFloat() else 0f,
        animationSpec = tween(durationMillis = animationDuration),
        label = "progressAnimation"
    )

    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.size(size)
    ) {
        Canvas(modifier = Modifier.size(size)) {
            val strokeWidthPx = strokeWidth.toPx()
            val canvasSize = size.toPx()

            drawArc(
                color = trackColor,
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(width = strokeWidthPx, cap = StrokeCap.Round),
                size = Size(canvasSize - strokeWidthPx, canvasSize - strokeWidthPx),
                topLeft = Offset(strokeWidthPx / 2, strokeWidthPx / 2)
            )

            drawArc(
                color = primaryColor,
                startAngle = -90f,
                sweepAngle = (currentPercentage / 100f) * 360f,
                useCenter = false,
                style = Stroke(width = strokeWidthPx, cap = StrokeCap.Round),
                size = Size(canvasSize - strokeWidthPx, canvasSize - strokeWidthPx),
                topLeft = Offset(strokeWidthPx / 2, strokeWidthPx / 2)
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "${currentPercentage.toInt()}%",
                style = Theme.textStyle.header.copy(
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = primaryColor
                ),
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "مكتمل",
                style = Theme.textStyle.header.copy(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = primaryColor
                ),
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    name = "Circular Progress Component"
)
@Composable
fun CircularProgressViewPreview() {
    Surface(
        modifier = Modifier.padding(32.dp),
        color = Color.White
    ) {
        CircularProgressView(
            percentage = 85
        )
    }
}