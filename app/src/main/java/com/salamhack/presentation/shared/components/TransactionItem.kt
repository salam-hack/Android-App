package com.salamhack.presentation.shared.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salamhack.R
import com.salamhack.presentation.shared.designSystem.theme.Theme

@Composable
fun TransactionItem(
    amount: String,
    date: String,
    time: String,
    title: String,
    category: String,
    @DrawableRes icon: Int,
    isIncome: Boolean,
    color: Color,
    modifier: Modifier = Modifier,
){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = if (isIncome) "+${amount} ج.م" else "-${amount} ج.م",
                style = Theme.textStyle.title.sub.copy(
                    textDirection = TextDirection.Rtl,
                    color = if (isIncome) Color(0xFF16A34A) else Theme.colors.bluePrimary
                ),
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Column(
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.spacedBy(1.dp)
                ) {
                    Text(
                        text = title,
                        style = Theme.textStyle.title.sub.copy(
                            textDirection = TextDirection.Rtl,
                            color = Theme.colors.bluePrimary
                        ),
                        modifier = Modifier
                    )
                    Text(
                        text = "$date، $time • $category",
                        style = Theme.textStyle.title.sub.copy(
                            fontSize = 11.sp,
                            textDirection = TextDirection.Rtl,
                            color = Color(0xFF90A1B9)
                        ),
                        modifier = Modifier
                    )
                }
                IconHolder(
                    icon = icon,
                    color = color,
                    hasBorder = false
                )
            }
        }

    }
}


@Preview(
    showBackground = true
)
@Composable
private fun Preview(){
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        TransactionItem(
            amount = "150",
            date = "25 أكتوبر",
            time = "09:00 ص",
            title = "الراتب الشهري",
            category = "دخل",
            icon = R.drawable.ic_work,
            isIncome = true,
            color = Color(0xFF00A63E)
        )
        TransactionItem(
            amount = "150",
            date = "25 أكتوبر",
            time = "09:00 ص",
            title = "الراتب الشهري",
            category = "دخل",
            icon = R.drawable.ic_work,
            isIncome = true,
            color = Color(0xFF00A63E)
        )
        TransactionItem(
            amount = "150",
            date = "25 أكتوبر",
            time = "09:00 ص",
            title = "الراتب الشهري",
            category = "دخل",
            icon = R.drawable.ic_work,
            isIncome = true,
            color = Color(0xFF00A63E)
        )
    }
}
