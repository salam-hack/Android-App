package com.salamhack.presentation.screen.subscriptions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import com.salamhack.R
import com.salamhack.presentation.shared.designSystem.theme.Theme

@Composable
fun SubscriptionsScreen(){
    SubscriptionsScreenContent()
}

@Composable
fun SubscriptionsScreenContent(
    modifier: Modifier = Modifier,
){
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF6F7FD))
            .statusBarsPadding()
    ){
        // blue section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(253.dp)
                .background(Theme.colors.bluePrimary)
        )
        Image(
            painter = painterResource(id = R.drawable.login_bg),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(253.dp)
        )

        // title
        Text(
            text = "الالتزامات والديون",
            style = Theme.textStyle.title.regular.copy(
                fontSize = 18.sp,
                color = Theme.colors.white,
                textDirection = TextDirection.Rtl
            ),
            modifier = Modifier
                .padding(top = 36.dp)
                .align(Alignment.TopCenter)
        )

        // Back Button
        Box(
            modifier = Modifier
                .padding(top = 28.dp, end = 18.dp)
                .size(44.dp)
                .background(Theme.colors.white, shape = RoundedCornerShape(16.dp))
                .align(Alignment.TopEnd)
                .clickable{
//                    action.onClickBack()
                },
            contentAlignment = Alignment.Center
        ){
            Icon(
                painterResource(id = R.drawable.ic_arrow_right),
                contentDescription = null,
                tint = Theme.colors.bluePrimary,
                modifier = Modifier
                    .size(24.dp)
            )
        }

        //body
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topEnd = 32.dp, topStart = 32.dp))
                .background(Color.White)
                .align(Alignment.BottomCenter)
                .padding(horizontal = 16.dp)
                .fillMaxHeight(0.85f)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                //item { AlertCard() }
                item { CustomTabRow() }
                item { SummaryWidget() }
                item {
                    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                        Gam3eyaCard(
                            title = "جمعية الشغل",
                            amount = "2,000",
                            isPaid = true,
                            role = "الدور الرابع"
                        )
                    }
                }
                item {
                    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                        Gam3eyaCard(
                            title = "جمعية العائلة",
                            amount = "1,500",
                            isPaid = false,
                            role = "الدور الأول (أنت)",
                            overdueText = "متأخر يومين"
                        )
                    }
                }
            }
        }
        FloatingActionButton(
            onClick = { /* TODO */ },
            containerColor = BluePrimary,
            contentColor = Color.White,
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 20.dp, bottom = 20.dp)
                .size(56.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_add),
                contentDescription = null,
                modifier = Modifier
            )
        }
    }
}

val BluePrimary = Color(0xFF003D9B)
val BlueDark = Color(0xFF0F3A70)
val BgLightGray = Color(0xFFF1F5F9)
val BgCardLight = Color(0xFFF8FAFC)
val TextGray = Color(0xFF62748E)

val AlertBg = Color(0xFFFEF2F2)
val AlertBorder = Color(0xFFFFC9C9)




@Composable
fun CustomTabRow() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("الجمعيات", "سلف وديون", "اشتراكات")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(BgLightGray, RoundedCornerShape(16.dp))
            .padding(6.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        tabs.forEachIndexed { index, title ->
            val isSelected = selectedTabIndex == index
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(12.dp))
                    .background(if (isSelected) Color.White else Color.Transparent)
                    .clickable { selectedTabIndex = index }
                    .padding(vertical = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = title,
                    style = Theme.textStyle.title.sub.copy(
                        color = if (isSelected) BlueDark else TextGray,
                        fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Normal,
                        textDirection = TextDirection.Rtl,
                        fontSize = 12.sp
                    ),
                )
            }
        }
    }
}

@Composable
fun SummaryWidget() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(BgCardLight, RoundedCornerShape(24.dp))
            .border(1.dp, BgLightGray, RoundedCornerShape(24.dp))
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(Color(0xFFEFF6FF), RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_people),
                contentDescription = null,
                tint = Theme.colors.bluePrimary,
                modifier = Modifier
            )
        }

        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = "إجمالي الأقساط الشهرية",
                style = Theme.textStyle.title.regular.copy(
                    color = TextGray,
                    fontSize = 12.sp
                ),
            )
            Row(verticalAlignment = Alignment.Bottom) {
                Text(
                    text = "ج.م",
                    style = Theme.textStyle.title.sub.copy(
                        color = TextGray,
                    ),
                    modifier = Modifier.padding(bottom = 4.dp, end = 4.dp)
                )
                Text(
                    text = "3,500",
                    style = Theme.textStyle.title.regular.copy(
                        color = BlueDark,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold
                    ),
                )
            }
        }
    }
}

@Composable
fun Gam3eyaCard(
    title: String,
    amount: String,
    isPaid: Boolean,
    role: String,
    progressTextCurrent: String = "الشهر 4",
    progressTextTotal: String = "من 10 أشهر",
    progress: Float = 0.4f,
    overdueText: String? = null,
    icon: Int = android.R.drawable.ic_menu_agenda
) {
    val cardBg = if (isPaid) Color.White else Color(0xFFFEF2F2).copy(alpha = 0.4f)
    val cardBorder = if (isPaid) Color(0xFFF1F5F9) else Color(0xFFFFE2E2)
    val iconBg = if (isPaid) Color(0xFFEFF6FF) else Color.White
    val iconBorder = if (isPaid) Color(0xFFDBEAFE) else Color(0xFFE2E8F0)

    val progressTrackColor = if (isPaid) Color(0xFFF1F5F9) else Color(0xFFE2E8F0).copy(alpha = 0.6f)
    val progressIndicatorColor = if (isPaid) Color(0xFFD4AF37) else Color(0xFFFB2C36)

    val primaryText = Color(0xFF0F3A70)
    val secondaryText = Color(0xFF62748E)
    val lightGrayText = Color(0xFF90A1B9)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(cardBg, RoundedCornerShape(24.dp))
            .border(1.dp, cardBorder, RoundedCornerShape(24.dp))
            .padding(20.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(iconBg, RoundedCornerShape(16.dp))
                            .border(1.dp, iconBorder, RoundedCornerShape(16.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(icon),
                            contentDescription = null,
                            tint = Color(0xFF45556C),
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    Column {
                        Text(
                            text = title,
                            style = Theme.textStyle.title.sub.copy(
                                color = Color(0xFF1D293D),
                            ),
                        )
                        Spacer(
                            modifier = Modifier
                                .height(2.dp)
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "القبض: ",
                                style = Theme.textStyle.title.sub.copy(
                                    color = secondaryText,
                                    fontSize = 11.sp
                                ),
                            )
                            Text(
                                text = "20,000 ج.م",
                                style = Theme.textStyle.title.sub.copy(
                                    color = Color(0xFF314158),
                                    fontSize = 11.sp
                                ),
                            )
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .background(if(isPaid) Color(0xFFF1F5F9) else Color.White, RoundedCornerShape(8.dp))
                        .border(1.dp, if(!isPaid) Color(0xFFE2E8F0) else Color.Transparent, RoundedCornerShape(8.dp))
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = role,
                        style = Theme.textStyle.title.sub.copy(
                            color = Color(0xFF45556C),
                            fontSize = 10.sp
                        ),
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Column {
                    Text(text = "القسط الشهري", color = lightGrayText, fontSize = 11.sp)
                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            text = amount,
                            color = if (isPaid) primaryText else Color(0xFFE7000B),
                            fontWeight = FontWeight.Normal,
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "ج.م",
                            color = if (isPaid) lightGrayText else Color(0xFFE7000B),
                            fontWeight = FontWeight.Bold,
                            fontSize = 10.sp,
                            modifier = Modifier.padding(bottom = 2.dp)
                        )
                    }
                }

                if (isPaid) {
                    Row(
                        modifier = Modifier
                            .background(Color(0xFFF0FDF4), RoundedCornerShape(12.dp))
                            .border(1.dp, Color(0xFFDCFCE7), RoundedCornerShape(12.dp))
                            .padding(horizontal = 12.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(Icons.Filled.CheckCircle, contentDescription = null, tint = Color(0xFF008236), modifier = Modifier.size(14.dp))
                        Text(text = "تم دفع هذا الشهر", color = Color(0xFF008236), fontWeight = FontWeight.Bold, fontSize = 11.sp)
                    }
                } else {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Button(
                            onClick = { /* TODO: تسديد القسط */ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF003D9B)),
                            shape = RoundedCornerShape(12.dp),
                            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp),
                            modifier = Modifier.height(32.dp)
                        ) {
                            Text("تسديد القسط", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        }

                        if (overdueText != null) {
                            Spacer(modifier = Modifier.height(4.dp))
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                Icon(Icons.Filled.Warning, contentDescription = null, tint = Color(0xFFE7000B), modifier = Modifier.size(12.dp))
                                Text(text = overdueText, color = Color(0xFFE7000B), fontWeight = FontWeight.Bold, fontSize = 10.sp)
                            }
                        }
                    }
                }
            }

            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .clip(RoundedCornerShape(50))
                        .background(progressTrackColor)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(fraction = progress)
                            .fillMaxHeight()
                            .clip(RoundedCornerShape(50))
                            .background(progressIndicatorColor)
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = progressTextCurrent, color = lightGrayText, fontSize = 10.sp, fontWeight = FontWeight.Medium)
                    Text(text = progressTextTotal, color = lightGrayText, fontSize = 10.sp, fontWeight = FontWeight.Medium)
                }
            }
        }
    }
}


@Preview
@Composable
fun Preview() {
    SubscriptionsScreen()
}