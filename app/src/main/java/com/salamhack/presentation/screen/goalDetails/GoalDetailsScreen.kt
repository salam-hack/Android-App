package com.salamhack.presentation.screen.goalDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salamhack.R
import com.salamhack.presentation.shared.components.AmountSummaryCard
import com.salamhack.presentation.shared.components.AppButton
import com.salamhack.presentation.shared.components.AppButtonType
import com.salamhack.presentation.shared.components.CircularProgressView
import com.salamhack.presentation.shared.components.RemainingTimeCard
import com.salamhack.presentation.shared.components.TransactionGoalItem
import com.salamhack.presentation.shared.designSystem.theme.Theme

@Composable
fun GoalDetailsScreen(){
    GoalDetailsScreenContent()
}

@Composable
fun GoalDetailsScreenContent(
    modifier: Modifier = Modifier
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
            text = "تفاصيل الهدف",
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
                .align(Alignment.TopEnd),
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
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Column(
                        modifier = Modifier
                            .padding(top = 32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "شراء MacBook Pro",
                            style = Theme.textStyle.header.copy(
                                color = Color(0xFF0F172B),
                                textDirection = TextDirection.Rtl
                            ),
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                text = "أجهزة إلكترونية",
                                style = Theme.textStyle.title.sub.copy(
                                    color = Color(0xFF62748E),
                                    textDirection = TextDirection.Rtl
                                ),
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.ic_laptop),
                                contentDescription = null,
                                tint = Color(0xFF62748E),
                                modifier = Modifier
                                    .size(16.dp)
                            )
                        }
                    }
                }
                item {
                    CircularProgressView(
                        percentage = 85,
                        modifier = Modifier
                            .padding(top = 24.dp)
                            .fillMaxWidth()
                    )
                }
                item {
                    AmountSummaryCard(
                        currentSaved = "25,000",
                        targetAmount = "80,000",
                        currency = "ج.م",
                        modifier = Modifier
                            .padding(top = 24.dp)
                    )
                }
                item {
                    RemainingTimeCard(
                        remainingTimeText = "متبقي 8 أشهر",
                        modifier = Modifier
                            .padding(top = 24.dp)
                    )
                }
                item {
                    Column(
                        modifier = Modifier
                            .padding(top = 24.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AppButton(
                            text = "إضافة مبلغ للهدف",
                            type = AppButtonType.PrimaryOutline,
                            icon = R.drawable.ic_add,
                            onClick = {}
                        )
                        Row(
                            modifier = Modifier
                                .padding(top = 12.dp),
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                        ){
                            AppButton(
                                text = "حذف الهدف",
                                type = AppButtonType.DangerSoft,
                                icon = R.drawable.ic_trash,
                                modifier = Modifier.weight(1f)
                            )
                            AppButton(
                                text = "تعديل الهدف",
                                type = AppButtonType.SecondarySoft,
                                icon = R.drawable.ic_edit,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }

                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "عرض الكل",
                            style = Theme.textStyle.title.sub.copy(
                                color = Theme.colors.bluePrimary
                            ),
                            modifier = Modifier
                                .clickable {

                                }
                        )
                        Text(
                            text = "سجل الإيداعات",
                            style = Theme.textStyle.title.regular.copy(
                                fontSize = 18.sp,
                                color = Color(0xFF0F172B)
                            )
                        )
                    }
                }
                item {
                    TransactionGoalItem(
                        title = "شراء مستلزمات",
                        date = "أمس، 08:15 م",
                        amount = "1,200",
                        isByAssistant = false,
                        showDivider = true
                    )
                }
                item {
                    TransactionGoalItem(
                        title = "شراء مستلزمات",
                        date = "أمس، 08:15 م",
                        amount = "1,200",
                        isByAssistant = true,
                        showDivider = true
                    )
                }
                item {
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
    }
}


@Preview
@Composable
private fun Preview(){
    GoalDetailsScreen()
}