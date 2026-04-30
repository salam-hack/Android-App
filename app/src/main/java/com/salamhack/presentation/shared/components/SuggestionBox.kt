package com.salamhack.presentation.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salamhack.R
import com.salamhack.presentation.shared.designSystem.theme.Theme

@Composable
fun SuggestionBox(
    modifier: Modifier = Modifier,
    text: String,
    iconPainter: Painter,
    onClick: () -> Unit = {},
) {
    val borderColor = Color(0xFFCBD5E1)

    Row(
        modifier = modifier
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
            .border(width = 1.dp, color = borderColor, shape = RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() }

            .padding(start = 12.dp, top = 4.dp, end = 4.dp, bottom = 4.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = text,
            style = Theme.textStyle.title.regular.copy(
                fontSize = 12.sp,
                color = Color(0xFF1E1E1E),
            )
        )

        Spacer(modifier = Modifier.width(10.dp))

        Box(
            modifier = Modifier
                .background(
                    color = Color(0xFFF8FAFC),
                    shape = RoundedCornerShape(12.dp)
                )
            .size(34.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = iconPainter,
                contentDescription = null,
                tint = Color(0xFF1E1E1E),
                modifier = Modifier.size(34.dp)
            )
        }
    }
}

@Preview
@Composable
private fun Preview(){
     SuggestionBox(
         text = "كيف يمكنني أن أبدأ؟",
         iconPainter = painterResource(id = R.drawable.ic_send),
         onClick = { /* Handle click */ }
     )
}