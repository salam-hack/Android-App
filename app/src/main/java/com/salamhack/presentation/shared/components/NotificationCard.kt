package com.salamhack.presentation.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salamhack.R
import com.salamhack.presentation.shared.designSystem.theme.Theme

@Composable
fun NotificationCard(
    title: String,
    description: String,
    time: String,
    modifier: Modifier = Modifier
) {
    val cardBorderColor = Color(0xFFE2E8F0)
    val iconTint = Color(0xFF1E3A8A)
    val titleColor = Color(0xFF1E293B)
    val descriptionColor = Color(0xFF64748B)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .border(
                width = 1.dp,
                color = cardBorderColor,
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
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                Text(
                    text = time,
                    style = Theme.textStyle.title.sub.copy(
                        fontSize = 10.sp,
                        color = descriptionColor,
                        textDirection = TextDirection.Rtl
                    ),
                    modifier = Modifier.padding(top = 2.dp)
                )
                Text(
                    text = title,
                    style = Theme.textStyle.title.sub.copy(
                        color = titleColor
                    ),
                )
            }


            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = description,
                style = Theme.textStyle.title.sub.copy(
                    fontSize = 12.sp,
                    textDirection = TextDirection.Rtl,
                    color = descriptionColor
                ),
                lineHeight = 22.sp
            )
        }

        Spacer(modifier = Modifier.width(12.dp))



        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White)
                .border(
                    width = 1.dp,
                    color = cardBorderColor,
                    shape = RoundedCornerShape(12.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_notification),
                contentDescription = "Notification Icon",
                tint = iconTint,
                modifier = Modifier.size(28.dp)
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF8FAFC,
    name = "Notification Card"
)
@Composable
fun NotificationCardPreview() {
    Surface(
        modifier = Modifier.padding(16.dp),
        color = Color.Transparent
    ) {
        NotificationCard(
            title = "تذكير: قسط جمعية العائلة",
            description = "قسط هذا الشهر (1,500 ج.م) مستحق غداً. يرجى التجهيز للسداد لتجنب التأخير.",
            time = "09:00 ص"
        )
    }
}