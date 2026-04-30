package com.salamhack.presentation.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.salamhack.R

@Composable
fun BotAvatar(
    modifier: Modifier = Modifier
) {
    val avatarBackgroundColor = Color(0xFF1C4297)
    val iconColor = Color(0xFFDFB338)

    Box(
        modifier = modifier
            .size(96.dp)
            .shadow(
                elevation = 16.dp,
                shape = RoundedCornerShape(32.dp),
                ambientColor = avatarBackgroundColor,
                spotColor = avatarBackgroundColor
            )
            .background(
                color = avatarBackgroundColor,
                shape = RoundedCornerShape(32.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_bot),
            contentDescription = "AI Avatar",
            tint = iconColor,
            modifier = Modifier.size(48.dp)
        )
    }
}

@Preview
@Composable
private fun Preview(){
    BotAvatar()
}