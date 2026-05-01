package com.salamhack.presentation.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.salamhack.R
import com.salamhack.presentation.shared.designSystem.theme.Theme

@Composable
fun RemainingTimeCard(
    remainingTimeText: String,
    modifier: Modifier = Modifier
) {
    val cardBackgroundColor = Color(0xFFF4F8FE)
    val cardBorderColor = Color(0xFFDCE8F5)
    val darkBlueColor = Color(0xFF1E3A8A)
    val iconBackgroundColor = Color(0xFFE6F0FF)
    val decorativeIconColor = Color(0xFFE2EDFA)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(72.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(cardBackgroundColor)
            .border(
                width = 1.dp,
                color = cardBorderColor,
                shape = RoundedCornerShape(16.dp)
            )
    ) {

        Row(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = remainingTimeText,
                style = Theme.textStyle.title.sub.copy(
                    color = darkBlueColor
                ),
            )

            Spacer(modifier = Modifier.width(12.dp))

            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(iconBackgroundColor),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_clock),
                    contentDescription = "الوقت المتبقي",
                    tint = darkBlueColor,
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_clock),
            contentDescription = null,
            tint = decorativeIconColor,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(x = (-24).dp)
                .size(100.dp)

        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    name = "Remaining Time Card Component"
)
@Composable
fun RemainingTimeCardPreview() {
    Surface(
        modifier = Modifier.padding(16.dp),
        color = Color.White
    ) {
        RemainingTimeCard(
            remainingTimeText = "متبقي 8 أشهر"
        )
    }
}