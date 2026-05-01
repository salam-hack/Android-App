package com.salamhack.presentation.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salamhack.R
import com.salamhack.presentation.shared.designSystem.theme.Theme

@Composable
fun TransactionGoalItem(
    title: String,
    date: String,
    amount: String,
    currency: String = "ج.م",
    isByAssistant: Boolean = true,
    showDivider: Boolean = true,
    modifier: Modifier = Modifier
) {
    val iconBgColor = if (isByAssistant) Color(0xFFF0FDF4) else Color(0xFFEFF6FF)
    val iconColor = if (isByAssistant) Color(0xFF16A34A) else Theme.colors.bluePrimary
    val amountColor = Theme.colors.lightGreen
    val icon = if (isByAssistant) R.drawable.ic_income else R.drawable.ic_star

    val amountPrefix = if (isByAssistant) "+" else "-"

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = currency,
                    style = Theme.textStyle.title.sub.copy(
                        color = amountColor
                    ),
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = "$amount$amountPrefix",
                    style = Theme.textStyle.title.sub.copy(
                        color = amountColor
                    ),
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = title,
                        style = Theme.textStyle.title.sub.copy(
                            color = Color(0xFF0F172B)
                        ),
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = date,
                        style = Theme.textStyle.title.sub.copy(
                            fontSize = 11.sp,
                            color = Color(0xFF90A1B9)
                        ),
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(iconBgColor),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = title,
                        tint = iconColor,
                        modifier = Modifier.size(24.dp)
                    )
                }

            }
        }

        if (showDivider) {
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp),
                thickness = 1.dp,
                color = Color(0xFFF1F5F9)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun Preview() {
    Surface(color = Color.White) {
        Column {
            TransactionGoalItem(
                title = "إيداع يدوي",
                date = "اليوم، 10:30 ص",
                amount = "5,000",
                isByAssistant = true
            )

            TransactionGoalItem(
                title = "شراء مستلزمات",
                date = "أمس، 08:15 م",
                amount = "1,200",
                isByAssistant = false,
                showDivider = false
            )
        }
    }
}