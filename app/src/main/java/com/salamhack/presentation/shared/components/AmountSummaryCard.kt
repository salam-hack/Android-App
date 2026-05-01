package com.salamhack.presentation.shared.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salamhack.presentation.shared.designSystem.theme.Theme

data class AmountSummaryUiState(
    val currentSaved: String = "0",
    val targetAmount: String = "0",
    val currency: String = "ج.م"
)

@Composable
fun AmountSummaryCard(
    currentSaved: String,
    targetAmount: String,
    currency: String = "ج.م",
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(82.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .border(
                border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        AmountSection(
            modifier = Modifier.weight(1f),
            title = "المدخر الحالي",
            amount = currentSaved,
            currency = currency
        )

        Box(
            modifier = Modifier
                .width(1.dp)
                .fillMaxHeight()
                .background(Color(0xFFE2E8F0))
        )

        AmountSection(
            modifier = Modifier.weight(1f),
            title = "المبلغ المستهدف",
            amount = targetAmount,
            currency = currency
        )
    }
}

@Composable
private fun AmountSection(
    title: String,
    amount: String,
    currency: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            style = Theme.textStyle.title.regular.copy(
                fontSize = 11.sp,
                color = Color(0xFF62748E)
            ),
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                text = currency,
                style = Theme.textStyle.title.regular.copy(
                    fontSize = 10.sp,
                    color = Color(0xFF90A1B9)
                ),
                modifier = Modifier.padding(bottom = 3.dp)
            )

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = amount,
                style = Theme.textStyle.title.regular.copy(
                    fontSize = 18.sp,
                    color = Color(0xFF0F3A70)
                ),
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF8FAFC,
    name = "Amount Summary Card"
)
@Composable
fun AmountSummaryCardPreview() {
    Surface(
        modifier = Modifier.padding(16.dp),
        color = Color.Transparent
    ) {
        AmountSummaryCard(
            currentSaved = "25,000",
            targetAmount = "80,000",
            currency = "ج.م"
        )
    }
}