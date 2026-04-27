package com.salamhack.presentation.shared.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salamhack.R
import com.salamhack.presentation.shared.designSystem.theme.Theme

@Composable
fun SmartAnalysisCard(
    amount: Int,
    trackedItemTitle: String,
    onClickAdd: () -> Unit,
    modifier: Modifier = Modifier,
){
    val gradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFFEFF6FF),
            Color(0xFFF8FAFC)
        ),
        start = Offset.Infinite,
        end = Offset.Zero
    )
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(gradient)
            .border(1.dp, Color(0xFFDBEAFE), RoundedCornerShape(24.dp))
            .padding(18.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.img_star),
            contentDescription = null,
            modifier = Modifier
                .offset(x = 45.dp, y = (-45).dp)
                .align(Alignment.TopEnd)
                .size(110.dp)
        )
        Row(
            modifier = Modifier
                .align(Alignment.TopEnd),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "تحليل ذكي للمصروفات",
                    style = Theme.textStyle.title.sub.copy(
                        textDirection = TextDirection.Rtl,
                        color = Theme.colors.bluePrimary
                    )
                )
                Text(
                    text = "إنفاقك على الترفيه أقل هذا الأسبوع. يمكنك إضافة ",
                    style = Theme.textStyle.title.sub.copy(
                        fontSize = 12.sp,
                        textDirection = TextDirection.Rtl,
                        color = Color(0xFF45556C)
                    )
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "إضافية لهدف الـ ${trackedItemTitle}!",
                        style = Theme.textStyle.title.sub.copy(
                            fontSize = 12.sp,
                            textDirection = TextDirection.Rtl,
                            color = Color(0xFF45556C)
                        )
                    )
                    Surface(
                        color = Color.White,
                        shape = RoundedCornerShape(4.dp),
                        tonalElevation = 2.dp,
                        shadowElevation = 6.dp
                    ) {
                        Text(
                            text = "$amount ج.م",
                            style = Theme.textStyle.title.sub.copy(
                                fontSize = 12.sp,
                                textDirection = TextDirection.Rtl,
                                color = Theme.colors.bluePrimary
                            ),
                            modifier = Modifier
                                .padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }

                Surface(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .clickable {
                            onClickAdd()
                        },
                    color = Color.White,
                    shape = RoundedCornerShape(12.dp),
                    tonalElevation = 2.dp,
                    shadowElevation = 6.dp,
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 6.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_left_arrow),
                            contentDescription = null,
                            tint = Theme.colors.bluePrimary
                        )
                        Text(
                            text = "إضافة للمدخرات",
                            style = Theme.textStyle.title.sub.copy(
                                fontSize = 12.sp,
                                textDirection = TextDirection.Rtl,
                                color = Theme.colors.bluePrimary
                            ),
                            modifier = Modifier
                        )
                    }
                }

            }
            IconContainer(
                icon = R.drawable.ic_star,
                color = Color(0xFFD4AF37)
            )
        }
    }
}

@Composable
fun IconContainer(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    color: Color,
){
    Box(
        modifier = modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(Theme.colors.white),
        contentAlignment = Alignment.Center
    ){
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = color,
            modifier = Modifier
                .size(20.dp)
        )
    }
}

@Preview
@Composable
private fun Preview(){
    SmartAnalysisCard(
        amount = 500,
        trackedItemTitle = "Mackbook",
        onClickAdd = {}
    )
}