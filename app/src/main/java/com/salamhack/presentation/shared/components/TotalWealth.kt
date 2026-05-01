package com.salamhack.presentation.shared.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salamhack.R
import com.salamhack.presentation.shared.designSystem.textStyle.ibm
import com.salamhack.presentation.shared.designSystem.theme.Theme

@Composable
fun TotalWealth(
    modifier: Modifier = Modifier,
    title: String,
    amountText: String,
    currencyText: String,
    secondCurrencyText: String = "ج.م",
    incomeLabel: String,
    incomeAmountText: String,
    expenseLabel: String,
    expenseAmountText: String,
    @DrawableRes incomeIcon: Int,
    @DrawableRes expenseIcon: Int,
    onEyeClick: (() -> Unit)? = null,

    // Styling options
    containerColor: Color = Color.White,
    titleColor: Color = Color(0xFF62748E),
    dividerColor: Color = Color(0xFFE9EEF6),
    incomeColor: Color = Color(0xFF00A63E),
    expenseColor: Color = Color(0xFFFB2C36),
    cornerRadius: Dp = 24.dp,

    initiallyHidden: Boolean = false,
    hiddenText: String = "••••",
) {
    var isHidden by rememberSaveable { mutableStateOf(initiallyHidden) }

    val shape = RoundedCornerShape(cornerRadius)

    val shownAmount = if (isHidden) hiddenText else amountText
    val shownIncome = if (isHidden) hiddenText else incomeAmountText
    val shownExpense = if (isHidden) hiddenText else expenseAmountText

    Box(
        modifier = modifier
            .fillMaxWidth()
            .shadow(elevation = 10.dp, shape = shape, clip = false)
            .clip(shape)
            .background(containerColor)
            .padding(horizontal = 18.dp, vertical = 24.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = title,
                    style = Theme.textStyle.title.sub.copy(color = titleColor),
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(end = 8.dp)
                )

                // eye icon
                Box(
                    modifier = Modifier.clickable {
                        isHidden = !isHidden
                        onEyeClick?.invoke()
                    }
                ) {
                    Icon(
                        painter = painterResource(
                            id = if (isHidden) R.drawable.ic_password_closed else R.drawable.ic_aye_open
                        ),
                        contentDescription = "visibility",
                        tint = Color(0xFF90A1B9),
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            // Amount row
            Row(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(bottom = 24.dp),
                verticalAlignment = Alignment.Bottom,
            ) {
                Text(
                    text = currencyText,
                    style = Theme.textStyle.title.regular.copy(
                        color = titleColor,
                        fontSize = 20.sp,
                    ),
                    modifier = Modifier.padding(bottom = 6.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = shownAmount,
                    style = TextStyle(
                        fontSize = 32.sp,
                        fontFamily = ibm,
                        fontWeight = FontWeight.SemiBold,
                        color = Theme.colors.bluePrimary
                    ),
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(dividerColor)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BottomStat(
                    modifier = Modifier.weight(1f),
                    label = expenseLabel,
                    value = shownExpense,
                    valueColor = expenseColor,
                    bubbleColor = expenseColor.copy(alpha = 0.10f),
                    iconTint = expenseColor,
                    icon = expenseIcon,
                    appendCurrency = !isHidden,
                    currencyText = secondCurrencyText
                )

                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .height(44.dp)
                        .background(dividerColor)
                )

                BottomStat(
                    modifier = Modifier.weight(1f),
                    label = incomeLabel,
                    value = shownIncome,
                    valueColor = incomeColor,
                    bubbleColor = incomeColor.copy(alpha = 0.10f),
                    iconTint = incomeColor,
                    icon = incomeIcon,
                    appendCurrency = !isHidden,
                    currencyText = secondCurrencyText
                )
            }
        }
    }
}

@Composable
private fun BottomStat(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    valueColor: Color,
    bubbleColor: Color,
    iconTint: Color,
    @DrawableRes icon: Int,
    appendCurrency: Boolean,
    currencyText: String = "ج.م",
) {
    Row(
        modifier = modifier.padding(horizontal = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = label,
                style = Theme.textStyle.title.regular.copy(
                    color = Color(0xFF90A1B9),
                    fontSize = 11.sp,
                ),
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))

            val valueText = if (appendCurrency) "$value $currencyText" else value

            Text(
                text = valueText,
                style = Theme.textStyle.title.sub.copy(
                    color = valueColor,
                    textDirection = TextDirection.Rtl
                ),
                overflow = TextOverflow.Ellipsis
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(bubbleColor),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = iconTint
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    TotalWealth(
        title = "إجمالي الرصيد الحالي",
        amountText = "15,400",
        currencyText = "ج.م",
        incomeLabel = "الدخل هذا الشهر",
        incomeAmountText = "20,000",
        expenseLabel = "المصروفات",
        expenseAmountText = "4,600",
        incomeIcon = R.drawable.ic_income,
        expenseIcon = R.drawable.ic_expense
    )
}