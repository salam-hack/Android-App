package com.salamhack.presentation.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salamhack.presentation.shared.designSystem.theme.Theme

@Composable
fun SenderMessageHolder(
    message: String,
    time: String,
    modifier: Modifier = Modifier
){
    Column() {
        Box(
            modifier = modifier
                .background(
                    Theme.colors.bluePrimary,
                    shape = RoundedCornerShape(topStart = 4.dp, topEnd = 16.dp, bottomStart = 16.dp, bottomEnd = 16.dp)
                )
        ){
            Text(
                text = message,
                style = Theme.textStyle.title.sub.copy(
                    color = Theme.colors.white,
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
                .padding(top = 8.dp, start = 4.dp)
                .align(Alignment.Start)
        )
    }
}

@Preview
@Composable
private fun Preview(){
    SenderMessageHolder(
        message = "فكرة ممتازة. قم بتطبيقها.",
        time = "11:47 ص"
    )
}