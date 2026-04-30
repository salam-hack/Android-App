package com.salamhack.presentation.shared.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salamhack.R
import com.salamhack.presentation.shared.designSystem.theme.Theme

@Composable
fun ChatCard(
    icon: Int,
    title: String,
    description: String,
    color: Color,
    time: String = "",
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .widthIn(max = 354.dp)
            .fillMaxWidth()
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
            .border(
                border = BorderStroke(1.dp, Color(0xFFF1F5F9)),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp),
        verticalAlignment = Alignment.Top
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.End
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = time,
                    style = Theme.textStyle.title.regular.copy(
                        fontSize = 10.sp,
                        color = Color(0xFF90A1B9),
                        textDirection = TextDirection.Rtl
                    ),
                )

                Text(
                    text = title,
                    style = Theme.textStyle.title.sub.copy(
                        color = Color(0xFF0F172B),
                        textAlign = TextAlign.End
                    ),
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = description,
                style = Theme.textStyle.title.sub.copy(
                    fontSize = 12.sp,
                    color = Color(0xFF45556C),
                    textAlign = TextAlign.End,
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }

        Spacer(modifier = Modifier.width(14.dp))

        Box(
            modifier = Modifier
                .size(56.dp)
                .background(
                    color = color.copy(alpha = 0.08f),
                    shape = RoundedCornerShape(12.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = title,
                tint = color,
                modifier = Modifier.size(28.dp)
            )
        }
    }
}

@Preview
@Composable
private fun Preview(){
    ChatCard(
        icon = R.drawable.ic_bot,
        title = "تحليل المصروفات الأسبوعية",
        description = " ج.م على المطاعم هذا الأسبوع وهو أعلى",
        color = Color(0xFFE17100),
        time = "09:30 ص",
        modifier = Modifier
    )
}