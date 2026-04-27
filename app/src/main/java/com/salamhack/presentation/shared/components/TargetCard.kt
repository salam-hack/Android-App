package com.salamhack.presentation.shared.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salamhack.R
import com.salamhack.presentation.shared.designSystem.theme.Theme


@Composable
fun TargetCard(
    modifier: Modifier = Modifier,
    title: String,
    targetAmount: String,
    saverAmount: String,
    percentage: Float,
    @DrawableRes icon: Int,
    remainingMonths: String
){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(Theme.colors.white)
            .padding(18.dp)
    ){
        PercentageHolder(
            modifier = Modifier
                .align(Alignment.TopStart),
            percentage = percentage.toInt(),
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopEnd),
            horizontalAlignment = Alignment.End
        ) {

            Row(
                modifier = Modifier,
            ) {
                Column(
                    modifier = Modifier
                        .padding(end = 12.dp),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ){
                    Text(
                        text = title,
                        style = Theme.textStyle.title.regular.copy(
                            textDirection = TextDirection.Rtl,
                            color = Theme.colors.bluePrimary
                        )
                    )
                    Text(
                        text = "هدف الادخار النشط",
                        style = Theme.textStyle.title.sub.copy(
                            fontSize = 12.sp,
                            textDirection = TextDirection.Rtl,
                            color = Theme.colors.grayNonActive
                        )
                    )
                }
                IconHolder(icon = icon)
            }

            AppProgressBar(
                modifier = Modifier.padding(top = 18.dp),
                percentage = percentage,
                color = Color(0xFFDDBF5F)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = Theme.textStyle.title.sub.copy(
                                color = Theme.colors.graySubTitles,
                            ).toSpanStyle()
                        ) {
                            append("المدخر: ")
                        }

                        withStyle(
                            style = Theme.textStyle.title.sub.copy(
                                color = Theme.colors.bluePrimary,
                            ).toSpanStyle()
                        ) {
                            append("$targetAmount ج.م")
                        }
                    }
                )

                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = Theme.textStyle.title.sub.copy(
                                color = Theme.colors.graySubTitles,
                            ).toSpanStyle()
                        ) {
                            append("الهدف: ")
                        }

                        withStyle(
                            style = Theme.textStyle.title.sub.copy(
                                color = Theme.colors.bluePrimary,
                            ).toSpanStyle()
                        ) {
                            append("$saverAmount ج.م")
                        }
                    }
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFFEFF6FF))
                    .border(1.dp, Color(0xFFDBEAFE), RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.CenterEnd
            ){
                Row(
                    modifier = Modifier
                        .padding(horizontal = 14.dp, vertical = 17.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .padding(end = 2.dp)
                            .background(Theme.colors.bluePrimary, shape = RoundedCornerShape(4.dp))
                    ){
                        Text(
                            text = "$remainingMonths أشهر",
                            style = Theme.textStyle.title.sub.copy(
                                fontSize = 12.sp,
                                textDirection = TextDirection.Rtl,
                                color = Theme.colors.white
                            ),
                            modifier = Modifier
                                .padding(vertical = 1.dp, horizontal = 6.dp)
                        )
                    }
                    Text(
                        text = "بمعدل ادخارك الحالي، ستصل لهدفك في ",
                        style = Theme.textStyle.title.sub.copy(
                            fontSize = 12.sp,
                            textDirection = TextDirection.Rtl,
                            color = Theme.colors.bluePrimary
                        ),
                        modifier = Modifier
                            .padding(end = 12.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.emoji_robot),
                        contentDescription = null
                    )
                }

            }
        }

    }
}

@Composable
fun PercentageHolder(
    modifier: Modifier = Modifier,
    percentage: Int,
    color: Color = Color(0xFFB89020)
){
    Box(
        modifier = modifier
            .background(color.copy(alpha = 0.1f), shape = CircleShape)
    ){
        Text(
            text = "${percentage}%",
            style = Theme.textStyle.title.regular.copy(
                fontSize = 12.sp,
                color = color
            ),
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 12.dp, vertical = 4.dp)
        )
    }
}

@Composable
fun IconHolder(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int
){
    Box(
        modifier = modifier
            .size(48.dp)
            .background(Theme.colors.blueBackground, shape = RoundedCornerShape(16.dp))
    ){
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = Theme.colors.bluePrimary,
            modifier = Modifier
                .align(Alignment.Center)
                .size(24.dp)
        )
    }
}

@Composable
fun AppProgressBar(
    modifier: Modifier = Modifier,
    percentage: Float,
    color: Color
){
    val progress = (percentage / 100f).coerceIn(0f, 1f)

    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(Color(0xFFF1F5F9))
            .height(12.dp)
            .fillMaxWidth()
    ){
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(color)
                .height(12.dp)
                .fillMaxWidth(progress)
                .align(Alignment.CenterEnd)
        )
    }
}



@Preview
@Composable
private fun Preview(){
    TargetCard(
        title = "شراء MacBook Pro",
        targetAmount = "80,000",
        saverAmount = "20,000",
        percentage = 25f,
        icon = R.drawable.ic_laptop,
        remainingMonths = "10"
    )
}