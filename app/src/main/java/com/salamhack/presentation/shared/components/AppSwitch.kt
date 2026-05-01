package com.salamhack.presentation.shared.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    activeColor: Color = Color(0xFF00C950),
    inactiveColor: Color = Color(0xFFD3D3D3),
    modifier: Modifier = Modifier
) {
    val backgroundColor by animateColorAsState(
        targetValue = if (checked) activeColor else inactiveColor,
        animationSpec = tween(durationMillis = 300),
        label = "backgroundColor"
    )

    val thumbOffset by animateDpAsState(
        targetValue = if (checked) 22.dp else 2.dp,
        animationSpec = tween(durationMillis = 300),
        label = "thumbOffset"
    )

    Box(
        modifier = modifier
            .size(width = 48.dp, height = 28.dp)
            .clip(CircleShape)
            .background(backgroundColor)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = { onCheckedChange(!checked) }
            ),
        contentAlignment = Alignment.CenterStart
    ) {
        Box(
            modifier = Modifier
                .padding(start = thumbOffset)
                .size(20.dp)
                .clip(CircleShape)
                .background(Color.White)
        )
    }
}

@Preview
@Composable
fun AppSwitchPreview() {
    var uiState by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier.padding(16.dp)
            .background(Color.White)
    ){
        AppSwitch(
            checked = uiState,
            onCheckedChange = { newState ->
                uiState = newState
            },
            modifier = Modifier,
            activeColor = Color(0xFF0F3A70)
        )
        AppSwitch(
            checked = uiState,
            onCheckedChange = { newState ->
                uiState = newState
            },
            modifier = Modifier
        )
        AppSwitch(
            checked = uiState,
            onCheckedChange = { newState ->
                uiState = newState
            },
            modifier = Modifier,
            activeColor = Color(0xFFE7000B)
        )
    }

}