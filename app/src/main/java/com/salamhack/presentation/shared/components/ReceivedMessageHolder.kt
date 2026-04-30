package com.salamhack.presentation.shared.components

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salamhack.R
import com.salamhack.presentation.shared.designSystem.theme.Theme

@Composable
fun ReceivedMessageHolder(
    message: String,
    time: String,
    modifier: Modifier = Modifier,
){
    Row(
        modifier = modifier
    ) {
        Column {
            Box(
                modifier = Modifier
                    .background(
                        Theme.colors.white,
                        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 4.dp, bottomStart = 16.dp, bottomEnd = 16.dp)
                    )
                    .border(
                        width = 1.dp,
                        color = Color(0xFFF1F5F9),
                        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 4.dp, bottomStart = 16.dp, bottomEnd = 16.dp)
                    )
            ){
                Text(
                    text = message,
                    style = Theme.textStyle.title.sub.copy(
                        color = Color(0xFF314158),
                        textDirection = TextDirection.Rtl
                    ),
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
            Text(
                text = time,
                style = Theme.textStyle.title.sub.copy(
                    fontSize = 10.sp,
                    color = Color(0xFF90A1B9),
                    textDirection = TextDirection.Rtl
                ),
                modifier = Modifier
                    .padding(top = 8.dp, end = 4.dp)
                    .align(Alignment.End)
            )
        }
        Box(
            modifier = Modifier
                .padding(start = 10.dp)
                .size(32.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF0F3A70),
                            Color(0xFF193CB8)
                        ),
                        start = Offset(0f, Float.POSITIVE_INFINITY),
                        end = Offset(Float.POSITIVE_INFINITY, 0f)
                    ),
                    shape = CircleShape
                )
                .border(
                    width = 1.dp,
                    color = Color(0x33FFFFFF),
                    shape = CircleShape
                )

        ){
            Icon(
                painter = painterResource(id = R.drawable.ic_bot),
                contentDescription = null,
                tint = Color(0xFFD4AF37),
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(16.dp)
            )
        }
    }
}

@Composable
fun TypingIndicatorHolder(modifier: Modifier = Modifier){
    Column {
        Box(
            modifier = Modifier
                .height(56.dp)
                .background(
                    Theme.colors.white,
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 4.dp, bottomStart = 16.dp, bottomEnd = 16.dp)
                )
                .border(
                    width = 1.dp,
                    color = Color(0xFFF1F5F9),
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 4.dp, bottomStart = 16.dp, bottomEnd = 16.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            TypingIndicator(modifier = Modifier.padding(horizontal = 24.dp))
        }
    }
}

@Composable
fun TypingIndicator(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "typing_indicator")

    val dotOffsets = List(3) { index ->
        infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = -8f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                ),
                repeatMode = RepeatMode.Reverse,
                initialStartOffset = StartOffset(offsetMillis = index * 150)
            ),
            label = "dot_offset_$index"
        )
    }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        dotOffsets.forEach { offset ->
            Box(
                modifier = Modifier
                    .offset(y = offset.value.dp)
                    .size(10.dp)
                    .background(color = Color(0xFFCBD5E1), shape = CircleShape)
            )
        }
    }
}

@Preview
@Composable
private fun PreviewTyping() {
    TypingIndicatorHolder()
}

@Preview
@Composable
private fun Preview(){
    ReceivedMessageHolder(
        message = "مرحباً أمير. بناءً على تحليلي لمصاريفك في آخر 3\n" +
                "أشهر، لاحظت أنك تنفق متوسط ",
        time = "11:46 ص"
    )
}