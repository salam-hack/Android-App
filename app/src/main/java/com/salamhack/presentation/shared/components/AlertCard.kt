package com.salamhack.presentation.shared.components

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salamhack.presentation.screen.subscriptions.AlertBg
import com.salamhack.presentation.screen.subscriptions.AlertBorder
import com.salamhack.presentation.shared.designSystem.theme.Theme
import com.salamhack.R

@Composable
fun AlertCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(AlertBg, RoundedCornerShape(16.dp))
            .border(1.dp, AlertBorder, RoundedCornerShape(16.dp))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.End,
        ) {
            Text(
                text = "يوجد التزام متأخر!",
                style = Theme.textStyle.title.sub.copy(
                    color = Color(0xFF9F0712),
                    textDirection = TextDirection.Rtl
                ),
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "قسط جمعية العائلة مستحق منذ يومين. يرجى التحديث لتجنب إرباك ميزانيتك.",
                style = Theme.textStyle.title.sub.copy(
                    fontSize = 12.sp,
                    color = Color(0xFFC10007),
                    textDirection = TextDirection.Rtl
                ),
            )
        }
        Box(
            modifier = Modifier
                .padding(start = 8.dp)
                .size(40.dp)
                .background(Color(0xFFFFE2E2), RoundedCornerShape(50)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_warning),
                contentDescription = null,
                tint = Color(0xFFE7000B),
                modifier = Modifier
            )
        }
    }
}

@Preview
@Composable
fun AlertCardPreview() {
    AlertCard()
}