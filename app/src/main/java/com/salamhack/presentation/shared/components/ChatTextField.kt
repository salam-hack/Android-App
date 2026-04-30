package com.salamhack.presentation.shared.components

import com.salamhack.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salamhack.presentation.shared.designSystem.theme.Theme

@Composable
fun ChatTextField(
    value: String,
    onValueChange: (String) -> Unit,
    onSendClick: () -> Unit,
    onMicClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    val backgroundColor = Color(0xFFF1F5F9)
    val primaryBlue = Theme.colors.bluePrimary
    val placeholderColor = Color(0xFF90A1B9)

    Row(
        modifier = modifier
            .width(358.dp)
            .height(58.dp)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(29.dp)
            )
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape)
                .background(primaryBlue)
                .clickable { onSendClick() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_send),
                contentDescription = "Send",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }

        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp),
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                textAlign = TextAlign.Right
            ),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    if (value.isEmpty()) {
                        Text(
                            text = "اسألني عن أي شيء...",
                            style = Theme.textStyle.title.sub.copy(
                                color = placeholderColor,
                                textAlign = TextAlign.Right,
                                textDirection = TextDirection.Rtl
                            ),
                        )
                    }
                    innerTextField()
                }
            }
        )

        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
                .background(Color.White)
                .clickable { onMicClick() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_mic),
                contentDescription = "Microphone",
                tint = primaryBlue,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    ChatTextField(
        value = "",
        onValueChange = {},
        onSendClick = {},
        onMicClick = {}
    )
}