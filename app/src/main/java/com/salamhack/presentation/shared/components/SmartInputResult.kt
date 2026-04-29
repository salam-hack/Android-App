package com.salamhack.presentation.shared.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salamhack.presentation.shared.designSystem.theme.Theme
import com.salamhack.R

@Composable
fun SmartInputResult(
    modifier: Modifier = Modifier,
    isIncome: Boolean = false,
    amount: String,
    categoryIcon: Int,
    category: String,
    date: String,
    note: String
){
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Theme.colors.white),
            contentAlignment = Alignment.Center
        ){
            Icon(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = null,
                tint = Color(0xFFD4AF37),
                modifier = Modifier
                    .size(20.dp)
            )
        }

        Text(
            text = "استخراج ذكي ناجح",
            style = Theme.textStyle.title.regular.copy(
                fontSize = 18.sp,
                color = Theme.colors.dark
            ),
            modifier = Modifier
                .padding(top = 12.dp)
        )
        Text(
            text = "يرجى مراجعة التفاصيل قبل الحفظ",
            style = Theme.textStyle.title.regular.copy(
                fontSize = 12.sp,
                color = Color(0xFF62748E)
            )
        )

        Box(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .padding(top = 24.dp)
                .background(Theme.colors.white, shape = RoundedCornerShape(24.dp))
                .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(24.dp))
                .fillMaxWidth()
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .align(Alignment.CenterHorizontally)
                        .background(if (isIncome) Theme.colors.lightGreen.copy(alpha = 0.1f) else Color(0xFFEFEF2F2),
                            shape = RoundedCornerShape(8.dp))
                        .border(
                            width = 1.dp,
                            color = if (isIncome) Theme.colors.lightGreen.copy(alpha = 0.5f) else Color(0xFFFFE2E2),
                            shape = RoundedCornerShape(8.dp)
                        )
                ){
                    Text(
                        text = if (isIncome) "دخل" else "مصروف",
                        style = Theme.textStyle.title.regular.copy(
                            fontSize = 12.sp,
                            color = if (isIncome) Theme.colors.lightGreen else Color(0xFFE7000B),
                        ),
                        modifier = Modifier
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                }

                Row(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "ج.م",
                        style = Theme.textStyle.title.regular.copy(
                            fontSize = 18.sp,
                            color = Color(0xFF90A1B9)
                        )
                    )
                    Text(
                        text = amount,
                        style = Theme.textStyle.header.copy(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 36.sp,
                            color = Theme.colors.dark
                        )
                    )
                }

                HorizontalDivider(
                    thickness = 1.dp,
                    color = Color(0xFFF1F5F9),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )

                DetailItem(
                    modifier = Modifier
                        .padding(top = 16.dp),
                    color = Color(0xFFFF6900),
                    icon = categoryIcon,
                    title = "التصنيف",
                    subTitle = category
                )

                DetailItem(
                    modifier = Modifier
                        .padding(top = 16.dp),
                    color = Color(0xFF0F3A70),
                    icon = R.drawable.ic_calender,
                    title = "التاريخ",
                    subTitle = date
                )

                DetailItem(
                    modifier = Modifier
                        .padding(vertical = 16.dp),
                    color = Color(0xFF45556C),
                    icon = R.drawable.ic_notes,
                    title = "ملاحظات",
                    subTitle = note
                )

            }

        }
    }
}

@Composable
fun DetailItem(
    modifier: Modifier = Modifier,
    color: Color = Color(0xFFFF6900),
    @DrawableRes icon: Int = R.drawable.ic_food,
    title: String = "التصنيف",
    subTitle: String = "طعام ومطاعم"
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = subTitle,
            style = Theme.textStyle.title.sub.copy(
                color = Color(0xFF0F172B)
            )
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = Theme.textStyle.title.sub.copy(
                    color = Color(0xFF62748E)
                )
            )
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(color.copy(alpha = 0.1f), shape = RoundedCornerShape(12.dp))
                    .border(1.dp, color.copy(alpha = 0.2f), shape = RoundedCornerShape(12.dp)),
            ){
                Icon(
                    painter = painterResource(icon),
                    contentDescription = null,
                    tint = color,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview(){
    SmartInputResult(
        modifier = Modifier,
        isIncome = false,
        amount = "500.00",
        categoryIcon = R.drawable.ic_food,
        category = "طعام ومطاعم",
        date = "أمس (24 أكتوبر)",
        note = "مطعم كشري"
    )
}