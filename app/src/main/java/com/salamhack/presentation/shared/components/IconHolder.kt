package com.salamhack.presentation.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun IconHolder(
    icon: Int,
    color: Color,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(color.copy(alpha = 0.1f))
            .border(1.dp, color.copy(alpha = 0.2f), RoundedCornerShape(14.dp))
            .size(64.dp)
    ){
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = color,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}