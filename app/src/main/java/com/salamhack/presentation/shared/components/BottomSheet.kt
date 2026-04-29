package com.salamhack.presentation.shared.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.salamhack.presentation.shared.designSystem.theme.Theme
import kotlinx.coroutines.launch

@Composable
fun BottomSheet(
    show: Boolean,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {

    if (!show) return

    var sheetHeight by remember { mutableStateOf(0f) }

    val offsetY = remember { androidx.compose.animation.core.Animatable(0f) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(sheetHeight) {
        if (sheetHeight > 0f) {
            offsetY.snapTo(sheetHeight)
            offsetY.animateTo(0f, animationSpec = tween(400))
        }
    }

    Box(Modifier.fillMaxSize()) {

        // Scrim
        AnimatedVisibility(
            visible = show,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Theme.colors.dark.copy(alpha = 0.5f))
                    .clickable { onDismiss() }
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset { IntOffset(0, offsetY.value.toInt()) }
                .pointerInput(sheetHeight) {
                    detectVerticalDragGestures(

                        onVerticalDrag = { _, dragAmount ->
                            val newOffset = offsetY.value + dragAmount
                            if (newOffset >= 0) {
                                scope.launch { offsetY.snapTo(newOffset) }
                            }
                        },

                        onDragEnd = {
                            val threshold = sheetHeight * 0.4f

                            if (offsetY.value > threshold) {
                                onDismiss()
                            } else {
                                scope.launch {
                                    offsetY.animateTo(0f)
                                }
                            }
                        }
                    )
                }
        ) {

            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .onSizeChanged {
                        sheetHeight = it.height.toFloat()
                    }
                    .background(
                        color = Theme.colors.white,
                        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                    )
                    .padding(bottom = 16.dp)
            ) {

                // Handle
                Box(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 8.dp)
                        .align(Alignment.CenterHorizontally)
                        .width(48.dp)
                        .height(6.dp)
                        .background(
                            color = Color(0xFFCAD5E2),
                            shape = CircleShape
                        )
                )

                content()
            }
        }
    }
}

@Preview
@Composable
private fun Preview(){
    BottomSheet(
        show = true,
        onDismiss = {},
        content = {}
    )
}
